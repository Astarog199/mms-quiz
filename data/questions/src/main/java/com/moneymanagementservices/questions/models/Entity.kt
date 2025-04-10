package com.moneymanagementservices.questions.models

import com.google.gson.annotations.SerializedName

data class Entity (
    @SerializedName("theme") val theme: String,
    @SerializedName("question") val question: String,
    @SerializedName("one") val one: String,
    @SerializedName("two") val two: String,
    @SerializedName("three") val three: String,
    @SerializedName("four") val four: String,
    @SerializedName("control") val control: String,
)