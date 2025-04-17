package com.moneymanagementservices.quiz.ui.quiz.present.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.moneymanagementservices.quiz.ui.quiz.domain.ShowThemeUseCase
import javax.inject.Inject

class ListViewModelFactory @Inject constructor(
    private val useCase: ShowThemeUseCase,
    private val mapper: PresentationMapper
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(ListViewModel::class.java) -> {
                @Suppress("UNCHEKED_CAST")
                return ListViewModel(
                    useCase = useCase,
                    mapper = mapper
                ) as T
            }
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}