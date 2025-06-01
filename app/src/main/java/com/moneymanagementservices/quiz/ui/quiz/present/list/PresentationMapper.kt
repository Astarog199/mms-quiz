package com.moneymanagementservices.quiz.ui.quiz.present.list

import com.moneymanagementservices.quiz.ui.quiz.domain.DomainEntity
import com.moneymanagementservices.quiz.ui.quiz.domain.TestDomain
import com.moneymanagementservices.quiz.ui.quiz.present.models.PresentationEntity
import com.moneymanagementservices.quiz.ui.quiz.present.models.PresentationInvestmentTests
import javax.inject.Inject

class PresentationMapper @Inject constructor() {

    fun toPresentationEntity(entity: DomainEntity): PresentationEntity {
        return PresentationEntity(
            theme = entity.theme,
            question = entity.question,
            one = entity.one,
            two = entity.two,
            three = entity.three,
            four = entity.four,
            control = entity.control
        )
    }

    fun toInvestmentTests(entity: TestDomain): PresentationInvestmentTests {
        return PresentationInvestmentTests(
            theme = entity.theme,
            question = entity.question?:0,
            answers = entity.answers?:0,
            result = entity.result
        )
    }

    fun toTestDomain(entity: PresentationInvestmentTests): TestDomain {
        return TestDomain(
            theme = entity.theme,
            question = entity.question,
            answers = entity.answers,
            result = entity.result
        )
    }
}