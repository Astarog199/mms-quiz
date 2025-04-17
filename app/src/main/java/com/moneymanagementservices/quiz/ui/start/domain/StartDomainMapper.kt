package com.moneymanagementservices.quiz.ui.start.domain

import com.moneymanagementservices.database.Education
import javax.inject.Inject

class StartDomainMapper @Inject constructor() {
    fun toDomainEntity(entity: Education): DomainEntity {
        return DomainEntity(
            head = entity.head,
            definitions = entity.definitions,
            firstParagraph = entity.firstParagraph,
            twoParagraph = entity.twoParagraph,
            threeParagraph = entity.threeParagraph,
            fourParagraph = entity.fourParagraph
        )
    }
}