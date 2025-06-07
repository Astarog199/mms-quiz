package com.moneymanagementservices.questions

import com.moneymanagementservices.database.InvestmentTests
import com.moneymanagementservices.database.Question
import com.moneymanagementservices.questions.models.QuestionEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import javax.inject.Inject

class Repository @Inject constructor(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val questionsList: QuestionsList,
    private val localDataSource: LocalDataSource,
    private val mapper: Mapper
) {
    private val scope = CoroutineScope(coroutineDispatcher)

    private fun saveQuestionsList(): Flow<List<Question>> {
        scope.launch {
            val entityList = questionsList.toEntity().entityList.map(mapper::toNewQuestion)
            localDataSource.saveQuestion(entityList)
        }

        return localDataSource.getQuestions()
    }

    fun showQuestion(): Flow<List<QuestionEntity>> {
        val entityList = questionsList.toEntity().entityList.map(mapper::toQuestion)
        return flowOf(entityList)
    }

    fun saveTheme(entity: InvestmentTests) {
        scope.launch {
            localDataSource.saveTheme(entity)
        }
    }

    fun showTest(): Flow<List<InvestmentTests>> {
        return localDataSource.getThemes()
    }

    fun update(entity: InvestmentTests) {
        scope.launch {
            localDataSource.updateInvestmentTests(entity)
        }
    }
}