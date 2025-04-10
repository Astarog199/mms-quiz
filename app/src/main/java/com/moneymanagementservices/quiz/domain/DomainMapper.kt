package com.moneymanagementservices.quiz.domain

import com.moneymanagementservices.database.InvestmentTests
import com.moneymanagementservices.database.Question
import javax.inject.Inject

class DomainMapper @Inject constructor() {

    fun toDomainQuestion(entity: Question): DomainEntity {
        return DomainEntity(
            theme = entity.theme,
            question = entity.question,
            one = entity.one,
            two = entity.two,
            three = entity.three,
            four = entity.four,
            control = entity.control,
        )
    }

    fun toTestDomain(entity: InvestmentTests): TestDomain {
        return TestDomain(
            theme = entity.theme,
            question = entity.question,
            answers = entity.answers,
            result = entity.result
        )
    }

    fun toInvestmentTests(entity: TestDomain): InvestmentTests {
        return InvestmentTests(
            theme = entity.theme,
            question = entity.question,
            answers = entity.answers,
            result = entity.result
        )
    }
}