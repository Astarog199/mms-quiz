package com.moneymanagementservices.education.models

import com.google.gson.annotations.SerializedName

data class EntityList (
    @SerializedName("margin_trading") val marginTrading: List<Entity>,
    @SerializedName("REPO_agreements") val REPO: List<Entity>,
    @SerializedName("futures_and_options") val futuresOptions: List<Entity>
)