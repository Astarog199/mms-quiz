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

    fun showEducations(): Flow<List<Education>> {
        return saveEducation()
    }


}