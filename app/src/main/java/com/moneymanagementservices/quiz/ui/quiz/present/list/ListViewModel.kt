package com.moneymanagementservices.quiz.ui.quiz.present.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moneymanagementservices.quiz.ui.quiz.domain.ShowThemeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update

class ListViewModel(
    private val useCase: ShowThemeUseCase,
    private val mapper: PresentationMapper
) : ViewModel() {
    private val _state = MutableStateFlow(ListScreenState())
    val state: StateFlow<ListScreenState> = _state.asStateFlow()

    fun load() {
        useCase()
            .map { it.map(mapper::toInvestmentTests) }
            .onStart { _state.update { it.copy(isLoading = true) } }
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

    fun changeDisplayResults(arg: Boolean) {
        _state.update { it.copy(displayTestResults = arg) }
    }
}