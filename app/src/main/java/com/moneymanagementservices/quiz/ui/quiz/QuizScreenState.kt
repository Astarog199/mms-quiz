package com.moneymanagementservices.quiz.ui.quiz

import com.moneymanagementservices.quiz.ui.models.PresentationEntity

data class QuizScreenState (
    val isLoading: Boolean = false,
    val filter: Boolean = false,
    val list: List<PresentationEntity> = mutableListOf(),
    val hasError: Boolean = false,
    val question: Int = 0,
    val answers: Int = 0,
)