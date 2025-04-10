package com.moneymanagementservices.quiz.domain

import com.moneymanagementservices.questions.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
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
            val arr = mutableSetOf<String>()
            questions.map { list ->
                arr.add(list.theme)
            }

            if (test.isEmpty() || test.size < arr.size) {
                arr.map { repository.saveTheme(factory.toInvestmentTests(it)) }
            }
            test.map(domainMapper::toTestDomain)
        }
    }
}