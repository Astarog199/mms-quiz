package com.moneymanagementservices.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "education")
data class Education (
    @PrimaryKey
    @ColumnInfo("head") val head: String,
    @ColumnInfo("definitions") val definitions: String,
    @ColumnInfo("first_paragraph") val firstParagraph: String,
    @ColumnInfo("two_paragraph") val twoParagraph: String,
    @ColumnInfo("three_paragraph") val threeParagraph: String,
    @ColumnInfo("four_paragraph") val fourParagraph: String,
)