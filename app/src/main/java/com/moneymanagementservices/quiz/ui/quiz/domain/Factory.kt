package com.moneymanagementservices.quiz.ui.quiz.domain

import com.moneymanagementservices.database.InvestmentTests
import javax.inject.Inject

class Factory @Inject constructor() {
    fun toInvestmentTests(theme: String): InvestmentTests {
        return InvestmentTests(
            theme = theme,
            question = 0,
            answers = 0,
            result = false
        )
    }
}