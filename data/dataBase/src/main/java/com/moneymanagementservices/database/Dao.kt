package com.moneymanagementservices.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Query("SELECT * FROM question")
    fun getQuestions(): Flow<List<Question>>

    @Insert(entity = Question::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveQuestion(entity: List<Question>)

    @Query("SELECT * FROM investment_tests")
    fun getThemes(): Flow<List<InvestmentTests>>

    @Insert(entity = InvestmentTests::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTheme(entity: InvestmentTests)

    @Update
    suspend fun updateInvestmentTests(entity: InvestmentTests)

    @Insert(entity = Education::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveEducation(entity: List<Education>)

    @Query("SELECT * FROM Education")
    fun getEducations(): Flow<List<Education>>
}