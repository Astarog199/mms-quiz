package com.moneymanagementservices.questions

import com.moneymanagementservices.database.NewQuestion
import com.moneymanagementservices.database.Question
import com.moneymanagementservices.questions.models.Entity
import javax.inject.Inject

class Mapper @Inject constructor() {
    fun toQuestion(entity: Entity): NewQuestion {
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
}