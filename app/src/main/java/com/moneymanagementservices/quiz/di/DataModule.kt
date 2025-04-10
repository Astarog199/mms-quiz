package com.moneymanagementservices.quiz.di

import android.content.Context
import com.moneymanagementservices.database.Dao
import com.moneymanagementservices.quiz.App
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
object DataModule {
    @Provides
    fun provideIOCoroutineDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    @Provides
    fun provideRoom(context: Context) : Dao {
        return (context as App).db.dao()
    }
}