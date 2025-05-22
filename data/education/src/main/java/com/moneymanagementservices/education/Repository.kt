package com.moneymanagementservices.education

import com.moneymanagementservices.database.Education
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class Repository @Inject constructor(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val educationText: EducationText,
    private val localDataSource: LocalDataSource,
    private val mapper: Mapper
) {
    private val scope = CoroutineScope(coroutineDispatcher)

    private fun saveEducation(): Flow<List<Education>> {
        scope.launch {
            val entityList = educationText.toEntity().marginTrading.map(mapper::toEducation)
            localDataSource.saveEducation(entityList)
        }

        return localDataSource.getEducations()
    }

    fun showEducationTopics(): List<String> {
        return localDataSource.showEducationTopics()
    }

    fun showEducations(educationTopic: String): List<Education> {
        return  when(educationTopic){
            "Маржинальная торговля" -> educationText.toEntity().marginTrading.map(mapper::toEducation)
            "Фьючерсы и опционы" -> educationText.toEntity().futuresOptions.map(mapper::toEducation)
            "Договора РЕПО" -> educationText.toEntity().REPO.map(mapper::toEducation)
            "Облигации" -> educationText.toEntity().bonds.map(mapper::toEducation)
            "Высокодоходные облигации с низким рейтингом (ВДО)" -> educationText.toEntity().bondsVDO.map(mapper::toEducation)
            "Структурные облигации" -> educationText.toEntity().structuredBonds.map(mapper::toEducation)
            "Облигации со структурным доходом" -> educationText.toEntity().structuredIncomeBonds.map(mapper::toEducation)
            "Акции" -> educationText.toEntity().stock.map(mapper::toEducation)
            "Иностранные акции" -> educationText.toEntity().foreignStock.map(mapper::toEducation)
            else -> mutableListOf()
        }
    }
}