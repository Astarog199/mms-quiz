package com.moneymanagementservices.quiz.ui.start.present.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.moneymanagementservices.quiz.ui.start.domain.ShowEducationTopicsUseCase
import javax.inject.Inject

class StartViewModelFactory @Inject constructor(
    private val showEducationTopics: ShowEducationTopicsUseCase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(StartViewModel::class.java) -> {
                @Suppress("UNCHEKED_CAST")
                return StartViewModel(
                    showEducationTopics = showEducationTopics
                ) as T
            }
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}