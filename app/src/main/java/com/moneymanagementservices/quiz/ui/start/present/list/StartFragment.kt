package com.moneymanagementservices.quiz.ui.start.present.list

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
import androidx.navigation.ui.navigateUp
import androidx.recyclerview.widget.LinearLayoutManager
import com.moneymanagementservices.quiz.App
import com.moneymanagementservices.quiz.R

import com.moneymanagementservices.quiz.databinding.FragmentStartBinding
import com.moneymanagementservices.quiz.ui.start.present.list.adapter.StartAdapter
import kotlinx.coroutines.launch
import javax.inject.Inject

class StartFragment : Fragment() {
    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!
    private val adapter = StartAdapter { item -> onItemClick(item) }


    @Inject
    lateinit var viewModelFactory: StartViewModelFactory

    private val viewModel: StartViewModel by viewModels {
        viewModelFactory
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (activity?.applicationContext as App).appComponent
            .startViewModelFactory()
            .create()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.load()
        binding.recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
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

    private fun showList(list: List<String>) {
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


    private fun onItemClick(item: String) {
        requireActivity().findNavController(R.id.fragment_container)
            .navigate(
                resId = R.id.navigation_education,
                args = bundleOf("title" to item)
            )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}