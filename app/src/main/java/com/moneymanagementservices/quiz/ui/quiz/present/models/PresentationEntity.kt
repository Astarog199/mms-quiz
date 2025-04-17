package com.moneymanagementservices.quiz.ui.quiz.present.models

data class PresentationEntity (
    val theme: String = "",
    val question: String = "",
    val one: String = "",
    val two: String = "",
    val three: String = "",
    val four: String = "",
    val control: String = "",
    val result: Boolean = false
)