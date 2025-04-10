package com.moneymanagementservices.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        Question::class,
        InvestmentTests::class
               ], version = 1
)
abstract class DB: RoomDatabase()  {
    abstract fun dao(): Dao
}