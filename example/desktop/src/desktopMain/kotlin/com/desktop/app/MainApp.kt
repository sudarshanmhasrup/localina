package com.desktop.app

import androidx.compose.ui.window.application
import com.compose.app.di.initKoin
import io.github.sudarshanmhasrup.splashify.SplashifyApp

fun main() {
    initKoin()
    application {
        SplashifyApp(splashScreen = { SplashScreen() }) {
            MainWindow()
        }
    }
}