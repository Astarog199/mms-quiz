package com.moneymanagementservices.quiz.ui.quiz.domain

import com.moneymanagementservices.questions.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class ShowThemeUseCase @Inject constructor(
    private val repository: Repository,
    private val domainMapper: DomainMapper,
    private val factory: Factory
) {
    operator fun invoke(): Flow<List<TestDomain>> {
        return combine(
            repository.showTest(),
            repository.showQuestion()
        ) { test, questions ->
            val arr = mutableMapOf<String, Int>()
            var lastTheme = ""
            questions.map {
                val currentTheme = it.theme

                if (currentTheme != lastTheme) {
                    arr[currentTheme] = 1
                } else {
                    arr[currentTheme] = arr.getValue(currentTheme) + 1
                }

                lastTheme = currentTheme
            }

            if (test.isEmpty() || test.size < arr.size) {
                arr.map { repository.saveTheme(factory.toInvestmentTests(it)) }
            }
            test.map(domainMapper::toTestDomain)
        }
    }
}