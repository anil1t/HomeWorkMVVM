package com.imaginato.homeworkmvvm.core

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
open class App : Application() {

    override fun onCreate() {
        super.onCreate()

        val context = applicationContext
    }

}