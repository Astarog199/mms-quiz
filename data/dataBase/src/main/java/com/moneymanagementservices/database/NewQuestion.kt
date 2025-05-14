package com.moneymanagementservices.database

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class NewQuestion (
    @PrimaryKey
    @ColumnInfo("id") val id: Int? = null,
    @ColumnInfo("theme") val theme: String,
    @ColumnInfo("question") val question: String,
    @ColumnInfo("one") val one: String,
    @ColumnInfo("two") val two: String,
    @ColumnInfo("three") val three: String,
    @ColumnInfo("four") val four: String,
    @ColumnInfo("control") val control: String,
)