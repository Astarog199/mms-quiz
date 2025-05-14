package com.moneymanagementservices.quiz.ui.start.present.details

import android.content.Context
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.moneymanagementservices.quiz.App
import com.moneymanagementservices.quiz.databinding.FragmentEducationBinding
import com.moneymanagementservices.quiz.ui.start.present.details.adapter.EducationAdapter
import com.moneymanagementservices.quiz.ui.start.present.details.models.EducationPresent
import kotlinx.coroutines.launch
import javax.inject.Inject

class EducationFragment : Fragment() {
    private var _binding: FragmentEducationBinding? = null
    private val binding get() = _binding!!
    private var title = ""
    private val adapter = EducationAdapter()

    @Inject
    lateinit var viewModelFactory: EducationViewModelFactory

    private val viewModel: EducationViewModel by viewModels {
        viewModelFactory
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (activity?.applicationContext as App).appComponent
            .educationViewModelFactory()
            .create()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEducationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments.let {
            title = it?.getString("title").toString()
        }

        viewModel.load(title)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    when {
                        state.isLoading -> showLoading()

                        state.hasError -> {
                            showError()
                            viewModel.errorShown()
                        }

                        else -> {
                            showList(state.list)
                        }
                    }
                }
            }
        }
    }


    private fun showLoading() {
        binding.recyclerView.visibility = View.GONE
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun showList(list: List<EducationPresent>) {
        adapter.setData(list)
        binding.recyclerView.visibility = View.VISIBLE
        binding.progressBar.visibility = View.GONE
    }

    private fun showError() {
        Toast.makeText(
            requireContext(),
            "Error wile loading dataText",
            Toast.LENGTH_SHORT
        ).show()
    }
}