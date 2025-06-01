package com.moneymanagementservices.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "investment_tests")
data class InvestmentTests (
    @PrimaryKey
    @ColumnInfo("theme") val theme: String,
    @ColumnInfo("quantity_question") val question: Int? = null,
    @ColumnInfo("quantity_answers") val answers: Int? = null,
    @ColumnInfo("result") val result: Boolean? = null,
)