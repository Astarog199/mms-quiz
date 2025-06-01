package com.moneymanagementservices.quiz.ui.quiz.present.test

import com.moneymanagementservices.quiz.ui.quiz.present.models.PresentationEntity

data class QuizScreenState (
    val isLoading: Boolean = false,
    val filter: Boolean = false,
    val list: Set<PresentationEntity> = mutableSetOf(),
    val hasError: Boolean = false,
    val question: Int = 0,
    val answers: Int = 0,
)