package com.moneymanagementservices.questions

import com.moneymanagementservices.database.NewQuestion
import com.moneymanagementservices.database.Question
import com.moneymanagementservices.questions.models.Entity
import com.moneymanagementservices.questions.models.QuestionEntity
import javax.inject.Inject

class Mapper @Inject constructor() {
    fun toNewQuestion(entity: Entity): NewQuestion {
        return NewQuestion(
            theme = entity.theme,
            question = entity.question,
            one = entity.one,
            two = entity.two,
            three = entity.three,
            four = entity.four,
            control = entity.control,
        )
    }

    fun toQuestion(entity: Entity): QuestionEntity {
        return QuestionEntity(
            theme = entity.theme,
            question = entity.question,
            one = entity.one,
            two = entity.two,
            three = entity.three,
            four = entity.four,
            control = entity.control,
        )
    }
}