package com.moneymanagementservices.quiz.ui.quiz.present.list

import com.moneymanagementservices.quiz.di.FragmentScope
import dagger.Subcomponent

@FragmentScope
@Subcomponent
interface ListComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create() : ListComponent
    }
    fun inject(fragment: ListFragment)
}