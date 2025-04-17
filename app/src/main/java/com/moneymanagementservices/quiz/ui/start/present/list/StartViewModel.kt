package com.moneymanagementservices.quiz.ui.start.present.list

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class StartViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(ScreenState())
    val state: StateFlow<ScreenState> = _state.asStateFlow()

    fun load() {
        val titlesList = toList()
        _state.update { state ->
            state.copy(isLoading = false, list = titlesList.entityList)
        }
    }

    fun errorShown() {
        _state.update { screenState -> screenState.copy(hasError = false) }
    }

    private fun toList(): PresentList {
        val gsonAdapter = Gson().getAdapter(PresentList::class.java)
        return gsonAdapter.fromJson(titles)
    }

    private val titles = """
        {
            "titles": [   
                            {
                                "title": "Маржинальная торговля",
                                "description": ""
                            },
                            {
                                "title": "Договора РЕПО",
                                "description": ""
                            }
                       ] 
        }
    """.trimIndent()
}