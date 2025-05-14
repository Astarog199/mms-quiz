package com.moneymanagementservices.quiz.ui.start.domain

import com.moneymanagementservices.education.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class EducationsUseCase @Inject constructor(
    private val repository: Repository,
    private val domainMapper: StartDomainMapper
) {
    operator fun invoke(educationTopic: String): Flow<List<DomainEntity>> {
        return flowOf(repository.showEducations(educationTopic)).map { it.map(domainMapper::toDomainEntity) }
    }
}