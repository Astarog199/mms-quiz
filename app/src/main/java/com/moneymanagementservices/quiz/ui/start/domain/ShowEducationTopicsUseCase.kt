package com.moneymanagementservices.quiz.ui.start.domain

import com.moneymanagementservices.education.Repository
import javax.inject.Inject

class ShowEducationTopicsUseCase @Inject constructor(
    private val repository: Repository,
) {
    operator fun invoke() : List<String> {
        return repository.showEducationTopics()
    }
}