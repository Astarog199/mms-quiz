package com.moneymanagementservices.quiz.ui.start.present.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.moneymanagementservices.quiz.ui.start.domain.EducationsUseCase
import javax.inject.Inject

class EducationViewModelFactory @Inject constructor(
    private val  useCase: EducationsUseCase,
    private val mapper: PresentMapper
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(EducationViewModel::class.java) -> {
                @Suppress("UNCHEKED_CAST")
                return EducationViewModel(
                    useCase = useCase,
                    mapper = mapper
                ) as T
            }
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}