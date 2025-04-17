package com.moneymanagementservices.education

import com.moneymanagementservices.database.Education
import com.moneymanagementservices.education.models.Entity
import javax.inject.Inject

class Mapper @Inject constructor() {
     fun toEducation(entity: Entity) : Education {
        return Education(
            head = entity.head,
            definitions = entity.definitions,
            firstParagraph = entity.firstParagraph,
            twoParagraph = entity.twoParagraph,
            threeParagraph = entity.threeParagraph,
            fourParagraph = entity.fourParagraph
        )
    }
}