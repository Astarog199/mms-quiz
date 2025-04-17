package com.moneymanagementservices.quiz.di

import android.content.Context
import com.moneymanagementservices.quiz.ui.quiz.present.list.ListComponent
import com.moneymanagementservices.quiz.ui.quiz.present.test.QuizComponent
import com.moneymanagementservices.quiz.ui.start.present.details.EducationComponent
import com.moneymanagementservices.quiz.ui.start.present.list.StartComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    DataModule::class,
    SubcomponentsModule::class,
])
interface AppComponent {
    fun startViewModelFactory(): StartComponent.Factory
    fun educationViewModelFactory(): EducationComponent.Factory
    fun quizComponentFactory(): QuizComponent.Factory
    fun listComponentFactory(): ListComponent.Factory

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
}