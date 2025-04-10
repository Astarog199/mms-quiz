package com.moneymanagementservices.quiz.ui.start

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class StartViewModelFactory @Inject constructor(

) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(StartViewModel::class.java) -> {
                @Suppress("UNCHEKED_CAST")
                return StartViewModel() as T
            }
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}