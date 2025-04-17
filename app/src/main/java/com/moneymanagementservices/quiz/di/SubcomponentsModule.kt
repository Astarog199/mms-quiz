package com.moneymanagementservices.quiz.di

import com.moneymanagementservices.quiz.ui.quiz.present.test.QuizComponent
import com.moneymanagementservices.quiz.ui.start.present.list.StartComponent
import dagger.Module

@Module(subcomponents = [
    StartComponent::class,
    QuizComponent::class,
])
object SubcomponentsModule