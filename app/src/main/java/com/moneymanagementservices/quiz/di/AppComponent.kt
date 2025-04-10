package com.moneymanagementservices.quiz.di

import android.content.Context
import com.moneymanagementservices.quiz.ui.list.ListComponent
import com.moneymanagementservices.quiz.ui.quiz.QuizComponent
import com.moneymanagementservices.quiz.ui.start.StartComponent
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
    fun quizComponentFactory(): QuizComponent.Factory
    fun listComponentFactory(): ListComponent.Factory

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
}