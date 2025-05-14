package com.moneymanagementservices.quiz.ui.start.present.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moneymanagementservices.quiz.ui.start.domain.EducationsUseCase
import com.moneymanagementservices.quiz.ui.start.present.details.models.ScreenState

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update

class EducationViewModel(
    private val  useCase: EducationsUseCase,
    private val mapper: PresentMapper
) : ViewModel() {
    private val _state = MutableStateFlow(ScreenState())
    val state: StateFlow<ScreenState> = _state.asStateFlow()

    fun load(arg: String) {
        useCase(arg)
            .map { list -> list.map(mapper::toEducationPresent) }
            .onStart { _state.update { it.copy(isLoading = true) }  }
            .onEach { list ->
                _state.update { screenState ->
                    screenState.copy(isLoading = false, list = list)
                }
            }
            .catch { _state.update { it.copy(hasError = true) } }
            .launchIn(viewModelScope)

    }

    fun errorShown() {
        _state.update { screenState -> screenState.copy(hasError = false) }
    }
}