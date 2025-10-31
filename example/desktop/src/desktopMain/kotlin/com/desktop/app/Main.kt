package com.desktop.app

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.compose.app.DesktopApp
import com.compose.app.di.initKoin

fun main() {
    initKoin()
    application {
        Window(title = "Localina Desktop Example", onCloseRequest = ::exitApplication) {
            DesktopApp()
        }
    }
}