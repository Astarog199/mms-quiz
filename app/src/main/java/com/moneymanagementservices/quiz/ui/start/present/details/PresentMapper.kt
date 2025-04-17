package com.moneymanagementservices.quiz.ui.start.present.details

import com.moneymanagementservices.quiz.ui.start.domain.DomainEntity
import com.moneymanagementservices.quiz.ui.start.present.details.models.EducationPresent
import javax.inject.Inject

class PresentMapper @Inject constructor() {
    fun toEducationPresent(entity: DomainEntity): EducationPresent {
        return EducationPresent(
            head = entity.head,
            definitions = entity.definitions,
            firstParagraph = entity.firstParagraph,
            twoParagraph = entity.twoParagraph,
            threeParagraph = entity.threeParagraph,
            fourParagraph = entity.fourParagraph
        )
    }
}