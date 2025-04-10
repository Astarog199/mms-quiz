package com.moneymanagementservices.questions.models

import com.google.gson.annotations.SerializedName

data class EntityList (
    @SerializedName("questions") val entityList: List<Entity>
)