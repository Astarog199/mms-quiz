package com.moneymanagementservices.quiz.ui.quiz.present.list

import android.content.Context
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.moneymanagementservices.quiz.App
import com.moneymanagementservices.quiz.R
import com.moneymanagementservices.quiz.databinding.FragmentListBinding
import com.moneymanagementservices.quiz.ui.quiz.present.list.adapter.ListAdapter
import com.moneymanagementservices.quiz.ui.quiz.present.models.PresentationInvestmentTests
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private val adapter = ListAdapter {item -> onItemClick(item)}
    private var displayResults = false
    private var question = 0
    private var answers = 0

    private fun onItemClick(item: PresentationInvestmentTests) {
        requireActivity().findNavController(R.id.fragment_container)
            .navigate(
                resId = R.id.action_list,
                args = bundleOf("theme" to item.theme)
            )
    }

    @Inject
    lateinit var viewModelFactory: ListViewModelFactory

    private val viewModel: ListViewModel by viewModels {
        viewModelFactory
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (activity?.applicationContext as App).appComponent
            .listComponentFactory()
            .create()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments.let {
            displayResults = it?.getBoolean("displayResults") == true
            question = it?.getInt("question") ?: 0
            answers = it?.getInt("answers") ?: 0
        }

        viewModel.load()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = adapter

        if (displayResults) viewModel.changeDisplayResults(true)

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    when {
                        state.isLoading -> showLoading()

                        state.hasError -> {
                            showError()
                            viewModel.errorShown()
                        }

                        state.displayTestResults -> displayTestResults()

                        else -> {
                            showList(state.list)
                        }
                    }
                }
            }
        }

        binding.resetResults.setOnClickListener {
            viewModel.changeDisplayResults(false)
        }
    }

    private fun displayTestResults() {
        val titleResult = if (answers > 7) getString(R.string.test_passed) else getString(R.string.test_failed)
        val textResult = context?.resources?.getString(R.string.correct_answers_out_of, answers, question)
        binding.displayResult.visibility = View.VISIBLE
        binding.progressBar.visibility = View.GONE
        binding.recyclerView.visibility = View.GONE
        binding.titleResult.text = titleResult
        binding.textResult.text = textResult
    }

    private fun showList(list: List<PresentationInvestmentTests>) {
        adapter.setData(list)
        binding.recyclerView.visibility = View.VISIBLE
        binding.progressBar.visibility = View.GONE
        binding.displayResult.visibility = View.GONE
    }

    private fun showError() {
        Toast.makeText(
            requireContext(),
            "Error wile loading dataText",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun showLoading() {
        binding.recyclerView.visibility = View.GONE
        binding.progressBar.visibility = View.VISIBLE
    }
}