package com.moneymanagementservices.quiz.ui.quiz.present.test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moneymanagementservices.quiz.ui.quiz.domain.ShowQuestionsUseCase
import com.moneymanagementservices.quiz.ui.quiz.domain.UpdateUseCase
import com.moneymanagementservices.quiz.ui.quiz.present.list.PresentationMapper
import com.moneymanagementservices.quiz.ui.quiz.present.models.PresentationInvestmentTests
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update

class QuizViewModel(
    private val useCase: ShowQuestionsUseCase,
    private val updateUseCase: UpdateUseCase,
    private val mapper: PresentationMapper
) : ViewModel() {
    private val _state = MutableStateFlow(QuizScreenState())
    val state: StateFlow<QuizScreenState> = _state.asStateFlow()

    fun load(theme: String) {
        useCase()
            .map { it.filter { it.theme == theme }.map(mapper::toPresentationEntity)}
            .onStart{ _state.update { list -> list.copy(isLoading = true) } }
            .onEach {  list ->
                _state.update { screenState ->
                    screenState.copy(isLoading = false, list = list, question = list.size)
                }
            }
            .catch { _state.update { it.copy(hasError = true) } }
            .launchIn(viewModelScope)
    }

    fun errorShown() {
        _state.update { screenState -> screenState.copy(hasError = false) }
    }

    fun countCorrectAnswers(arg: Boolean){
        if (arg) {
            val quantity = _state.value.answers + 1
            _state.update { it.copy(answers = quantity) }
        }
    }

    fun saveTestResult(entity: PresentationInvestmentTests) {
        val answers = _state.value.answers
        val question = _state.value.question
        val result = answers == question
        val updateEntity = entity.copy(question = question, answers = answers, result = result)

        updateUseCase(mapper.toTestDomain(updateEntity))
    }
}