package com.moneymanagementservices.questions

import com.moneymanagementservices.database.Dao
import com.moneymanagementservices.database.InvestmentTests
import com.moneymanagementservices.database.NewQuestion
import com.moneymanagementservices.database.Question
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val dao: Dao
){
    fun getQuestions(): Flow<List<Question>> {
      return dao.getQuestions()
    }

    suspend fun saveQuestion(entity: List<NewQuestion>) {
        dao.saveQuestion(entity)
    }

    suspend fun saveTheme(entity: InvestmentTests) {
        dao.saveTheme(entity)
    }

    fun getThemes(): Flow<List<InvestmentTests>> {
        return dao.getThemes()
    }

    suspend fun updateInvestmentTests(entity: InvestmentTests) {
        return dao.updateInvestmentTests(entity)
    }
}