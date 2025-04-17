package com.moneymanagementservices.quiz.ui.start.domain

import com.moneymanagementservices.education.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class EducationsUseCase @Inject constructor(
    private val repository: Repository,
    private val domainMapper: StartDomainMapper
) {
    operator fun invoke(): Flow<List<DomainEntity>> {
        return repository.showEducations().map { it.map(domainMapper::toDomainEntity) }
    }
}