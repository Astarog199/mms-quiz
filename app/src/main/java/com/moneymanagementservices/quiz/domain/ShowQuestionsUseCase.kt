package com.moneymanagementservices.quiz.domain

import com.moneymanagementservices.questions.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ShowQuestionsUseCase @Inject constructor(
    private val repository: Repository,
    private val domainMapper: DomainMapper
){
    operator fun invoke(): Flow<List<DomainEntity>> {
        return repository.showQuestion().map { it.map(domainMapper::toDomainQuestion) }
    }
}