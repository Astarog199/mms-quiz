package com.moneymanagementservices.quiz.ui.start.present.details.models

data class ScreenState(
    val isLoading: Boolean = false,
    val filter: Boolean = false,
    val list: List<EducationPresent> = mutableListOf(),
    val hasError: Boolean = false,
)