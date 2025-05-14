package com.moneymanagementservices.quiz.ui.start.present.list

data class ScreenState (
    val isLoading: Boolean = false,
    val filter: Boolean = false,
    val list: List<String> = mutableListOf(),
    val hasError: Boolean = false,
)