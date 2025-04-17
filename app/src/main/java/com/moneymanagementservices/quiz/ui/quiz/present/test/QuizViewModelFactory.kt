package com.moneymanagementservices.quiz.ui.quiz.present.test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.moneymanagementservices.quiz.ui.quiz.domain.ShowQuestionsUseCase
import com.moneymanagementservices.quiz.ui.quiz.domain.UpdateUseCase
import com.moneymanagementservices.quiz.ui.quiz.present.list.PresentationMapper
import javax.inject.Inject

class QuizViewModelFactory @Inject constructor(
    private val useCase: ShowQuestionsUseCase,
    private val updateUseCase: UpdateUseCase,
    private val mapper: PresentationMapper
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(QuizViewModel::class.java) -> {
                @Suppress("UNCHEKED_CAST")
                return QuizViewModel(
                    useCase = useCase,
                    updateUseCase = updateUseCase,
                    mapper = mapper
                ) as T
            }
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}