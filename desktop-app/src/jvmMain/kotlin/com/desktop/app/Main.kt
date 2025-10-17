package com.desktop.app


import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.compose.app.JvmApp
import com.compose.app.di.initKoin

fun main() {
    initKoin()
    application {
        Window(onCloseRequest = ::exitApplication, title = "Localina Desktop Example") {
            JvmApp()
        }
    }
}