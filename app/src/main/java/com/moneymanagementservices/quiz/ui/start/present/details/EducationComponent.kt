package com.moneymanagementservices.quiz.ui.start.present.details

import com.moneymanagementservices.quiz.di.FragmentScope
import dagger.Subcomponent

@FragmentScope
@Subcomponent
interface EducationComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create() : EducationComponent
    }
    fun inject(fragment: EducationFragment)
}