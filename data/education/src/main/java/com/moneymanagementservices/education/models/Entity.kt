package com.moneymanagementservices.education.models

import com.google.gson.annotations.SerializedName

data class Entity (
    @SerializedName("head") val head: String,
    @SerializedName("definitions") val definitions: String,
    @SerializedName("first_paragraph") val firstParagraph: String,
    @SerializedName("two_paragraph") val twoParagraph: String,
    @SerializedName("three_paragraph") val threeParagraph: String,
    @SerializedName("four_paragraph") val fourParagraph: String,
)