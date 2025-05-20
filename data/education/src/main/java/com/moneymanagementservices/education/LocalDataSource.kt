package com.moneymanagementservices.education

import com.moneymanagementservices.database.Dao
import com.moneymanagementservices.database.Education
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val dao: Dao
){
    suspend fun saveEducation(entity: List<Education>) {
        dao.saveEducation(entity)
    }

    fun getEducations(): Flow<List<Education>> {
        return dao.getEducations()
    }

    fun showEducationTopics(): List<String> {
         val arr = listOf(
            "Маржинальная торговля",
            "Фьючерсы и опционы",
            "Договора РЕПО",
            "Облигации",
            "Высокодоходные облигации с низким рейтингом (ВДО)",
            "Еврооблигации",
            "Конвертируемые облигации",
            "Структурные облигации",
            "Облигации со структурным доходом",
            "Акции"
        )
        return arr
    }
}