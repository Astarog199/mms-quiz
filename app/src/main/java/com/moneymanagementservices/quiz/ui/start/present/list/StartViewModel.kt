package com.moneymanagementservices.quiz.ui.start.present.list

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.moneymanagementservices.quiz.ui.start.domain.ShowEducationTopicsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class StartViewModel @Inject constructor(
    private val showEducationTopics: ShowEducationTopicsUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(ScreenState())
    val state: StateFlow<ScreenState> = _state.asStateFlow()

    fun load() {
        _state.update { state ->
            state.copy(isLoading = false, list = showEducationTopics())
        }
    }

    fun errorShown() {
        _state.update { screenState -> screenState.copy(hasError = false) }
    }
}