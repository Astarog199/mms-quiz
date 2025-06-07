package com.moneymanagementservices.quiz

import android.app.Application
import com.moneymanagementservices.database.DB
import com.moneymanagementservices.quiz.di.AppComponent
import com.moneymanagementservices.quiz.di.DaggerAppComponent
import androidx.room.Room


class App: Application() {
    lateinit var db: DB
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.factory().create(this)

        db = Room.databaseBuilder(
            applicationContext,
            DB::class.java,
            "db"
        ).fallbackToDestructiveMigration().build()
    }
}