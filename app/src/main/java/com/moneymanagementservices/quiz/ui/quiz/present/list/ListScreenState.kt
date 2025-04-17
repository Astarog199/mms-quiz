package com.moneymanagementservices.quiz.ui.quiz.present.list

import com.moneymanagementservices.quiz.ui.quiz.present.models.PresentationInvestmentTests

data class ListScreenState (
    val isLoading: Boolean = false,
    val filter: Boolean = false,
    val list: List<PresentationInvestmentTests> = mutableListOf(),
    val hasError: Boolean = false,
)