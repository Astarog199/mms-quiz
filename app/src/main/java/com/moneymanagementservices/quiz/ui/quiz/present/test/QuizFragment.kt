package com.moneymanagementservices.quiz.ui.quiz.present.test

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
import com.google.android.material.snackbar.Snackbar
import com.moneymanagementservices.quiz.App
import com.moneymanagementservices.quiz.R
import com.moneymanagementservices.quiz.databinding.FragmentQuizBinding
import com.moneymanagementservices.quiz.ui.quiz.present.models.PresentationEntity
import com.moneymanagementservices.quiz.ui.quiz.present.models.PresentationInvestmentTests
import kotlinx.coroutines.launch
import javax.inject.Inject

class QuizFragment : Fragment() {
    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!
    private var index = 0
    private var theme = ""

    @Inject
    lateinit var viewModelFactory: QuizViewModelFactory

    private val viewModel: QuizViewModel by viewModels {
        viewModelFactory
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (activity?.applicationContext as App).appComponent
            .quizComponentFactory()
            .create()
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments.let {
            theme = it?.getString("theme").toString()
        }

        viewModel.load(theme)

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
                            showItem(state.list)
                        }
                    }
                }
            }
        }
    }

    private fun showError() {
        Toast.makeText(
            requireContext(),
            "Error wile loading dataText",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun showItem(list: List<PresentationEntity>) {
        var result = false
        val item = list.getOrNull(index)
        val NONE = -1

        with(binding) {
            answer.visibility = View.GONE
            showAnswer.visibility = View.VISIBLE

            question.text = item?.question
            optionOne.text = item?.one
            optionTwo.text = item?.two
            optionThree.text = item?.three
            optionFour.text = item?.four

            showAnswer.setOnClickListener {
                answer.visibility = View.VISIBLE
                showAnswer.visibility = View.GONE
                answer.text = item?.control
            }

            options.clearCheck()

            options.setOnCheckedChangeListener { _, button ->
                when (button) {
                    binding.optionOne.id -> {
                        result = item?.one == item?.control
                        actionAnswer.visibility = View.VISIBLE
                    }

                    binding.optionTwo.id -> {
                        result = item?.two == item?.control
                        actionAnswer.visibility = View.VISIBLE
                    }

                    binding.optionThree.id -> {
                        result = item?.three == item?.control
                        actionAnswer.visibility = View.VISIBLE
                    }

                    binding.optionFour.id -> {
                        result = item?.four == item?.control
                        actionAnswer.visibility = View.VISIBLE
                    }

                    NONE -> actionAnswer.visibility = View.GONE
                }
            }

            actionAnswer.setOnClickListener {
                index++
                item?.let {
                    onItemClick(it.copy(result = result))
                    showSnackbar(result.toString())
                }

                when{
                    item != list.last() -> showItem(list)

                    else -> {
                        viewModel.saveTestResult(entity = PresentationInvestmentTests(theme = theme))
                        navigate()
                        val message = "${viewModel.state.value.question}/${viewModel.state.value.answers}"
                        showSnackbar(message)
                    }
                }
            }
            progressBar.visibility = View.GONE
        }
    }

    private fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun onItemClick(item: PresentationEntity) {
        viewModel.countCorrectAnswers(item.result)
    }

    private fun showSnackbar(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
    }

    private fun navigate() {
        requireActivity().findNavController(R.id.fragment_container)
            .navigate(
                resId = R.id.actrion_finish,
                args = bundleOf(
                    "displayResults" to true,
                    "question" to viewModel.state.value.question,
                    "answers" to viewModel.state.value.answers
                    )
            )
    }
}