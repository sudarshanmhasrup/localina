package com.android.app

import android.app.Application
import com.compose.app.di.initKoin
import org.koin.android.ext.koin.androidContext

class LocalinaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@LocalinaApplication)
        }
    }
}