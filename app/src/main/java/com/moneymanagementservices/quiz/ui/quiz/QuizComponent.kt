package com.moneymanagementservices.quiz.ui.quiz

import com.moneymanagementservices.quiz.di.FragmentScope
import dagger.Subcomponent

@FragmentScope
@Subcomponent
interface QuizComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create() : QuizComponent
    }
    fun inject(fragment: QuizFragment)
}