package com.moneymanagementservices.questions

import com.moneymanagementservices.database.Question
import com.moneymanagementservices.questions.models.Entity
import javax.inject.Inject

class Mapper @Inject constructor() {
    fun toQuestion(entity: Entity): Question {
        return Question(
            question = entity.question,
            theme = entity.theme,
            one = entity.one,
            two = entity.two,
            three = entity.three,
            four = entity.four,
            control = entity.control,
        )
    }
}