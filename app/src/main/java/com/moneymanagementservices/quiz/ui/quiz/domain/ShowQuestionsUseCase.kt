package com.moneymanagementservices.quiz.ui.quiz.domain

import com.moneymanagementservices.questions.Repository as QuestionsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ShowQuestionsUseCase @Inject constructor(
    private val repository: QuestionsRepository,
    private val domainMapper: DomainMapper
){
    operator fun invoke(): Flow<List<DomainEntity>> {
        return repository.showQuestion().map { it.map(domainMapper::toDomainQuestion) }
    }
}