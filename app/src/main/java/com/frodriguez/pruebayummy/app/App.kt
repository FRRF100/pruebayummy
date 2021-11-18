package com.frodriguez.pruebayummy.app

import android.app.Application
import com.frodriguez.pruebayummy.model.AppDatabase

class App : Application() {

    val applicationGraph: ApplicationGraph = DaggerApplicationGraph.create()
    lateinit var appDatabase: AppDatabase

    override fun onCreate() {
        super.onCreate()
        appDatabase = AppDatabase.invoke(applicationContext)
    }

}