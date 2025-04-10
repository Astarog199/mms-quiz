package com.moneymanagementservices.quiz.di

import com.moneymanagementservices.quiz.ui.quiz.QuizComponent
import com.moneymanagementservices.quiz.ui.start.StartComponent
import dagger.Module

@Module(subcomponents = [
    StartComponent::class,
    QuizComponent::class,
])
object SubcomponentsModule