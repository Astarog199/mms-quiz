package com.moneymanagementservices.quiz.ui.quiz.domain

import com.moneymanagementservices.questions.Repository
import javax.inject.Inject

class UpdateUseCase @Inject constructor(
    private val repository: Repository,
    private val domainMapper: DomainMapper
) {
    operator fun invoke(entity: TestDomain) {
        val investmentTests = domainMapper.toInvestmentTests(entity)
        repository.update(investmentTests)
    }
}