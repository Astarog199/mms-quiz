package com.moneymanagementservices.quiz.ui.start.present.list

import com.google.gson.annotations.SerializedName

data class PresentList (
    @SerializedName("titles") val entityList: List<PresentEntity>

)

data class PresentEntity(
    @SerializedName("title") val title: String = "",
    @SerializedName("description")val description: String = "",
)