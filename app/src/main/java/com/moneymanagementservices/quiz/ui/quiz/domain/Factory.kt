package com.moneymanagementservices.quiz.ui.quiz.domain

import com.moneymanagementservices.database.InvestmentTests
import javax.inject.Inject

class Factory @Inject constructor() {
    fun toInvestmentTests(theme: Map.Entry<String, Int>): InvestmentTests {
        return InvestmentTests(
            theme = theme.key,
            question = theme.value,
            answers = 0,
            result = false
        )
    }
}