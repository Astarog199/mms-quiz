package com.moneymanagementservices.quiz.ui.start.present.list

import com.moneymanagementservices.quiz.di.FragmentScope
import dagger.Subcomponent

@FragmentScope
@Subcomponent
interface StartComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create() : StartComponent
    }
    fun inject(fragment: StartFragment)
}