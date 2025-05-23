package com.moneymanagementservices.education.models

import com.google.gson.annotations.SerializedName

data class EntityList (
    @SerializedName("margin_trading") val marginTrading: List<Entity>,
    @SerializedName("futures_and_options") val futuresOptions: List<Entity>,
    @SerializedName("REPO_agreements") val REPO: List<Entity>,
    @SerializedName("bonds") val bonds: List<Entity>,
    @SerializedName("bonds_VDO") val bondsVDO: List<Entity>,
    @SerializedName("euro_bonds") val euroBonds: List<Entity>,
    @SerializedName("convertible_bonds") val convertibleBonds: List<Entity>,
    @SerializedName("structured_bonds") val structuredBonds: List<Entity>,
    @SerializedName("structured_income_bonds") val structuredIncomeBonds: List<Entity>,
    @SerializedName("stocks_market") val stock: List<Entity>,
    @SerializedName("foreign_stock") val foreignStock: List<Entity>,
    @SerializedName("closed_end_mutual_funds") val zpif: List<Entity>,
    @SerializedName("shares_not_included_in_quotation_lists") val sharesNotIncludedQuotationLists: List<Entity>,
    @SerializedName("ETF_theme_first") val ETFthemeFirst: List<Entity>,
    @SerializedName("foreign_bonds") val foreignBonds: List<Entity>,
    @SerializedName("bonds_governed_foreign_law") val bondsGovernedForeignLaw: List<Entity>
)