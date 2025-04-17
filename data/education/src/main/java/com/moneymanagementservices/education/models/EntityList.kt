package com.moneymanagementservices.education.models

import com.google.gson.annotations.SerializedName

data class EntityList (
    @SerializedName("margin_trading") val marginTrading: List<Entity>,
    @SerializedName("REPO_agreements") val REPO: List<Entity>
)