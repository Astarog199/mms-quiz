package com.moneymanagementservices.education.models

import com.google.gson.annotations.SerializedName

data class EntityList (
    @SerializedName("margin_trading") val marginTrading: List<Entity>,
    @SerializedName("futures_and_options") val futuresOptions: List<Entity>,
    @SerializedName("REPO_agreements") val REPO: List<Entity>,
    @SerializedName("bonds") val bonds: List<Entity>,
    @SerializedName("bonds_VDO") val bondsVDO: List<Entity>,
    @SerializedName("structured_bonds") val structuredBonds: List<Entity>,
    @SerializedName("structured_income_bonds") val structuredIncomeBonds: List<Entity>,
    @SerializedName("stocks_market") val stock: List<Entity>
)