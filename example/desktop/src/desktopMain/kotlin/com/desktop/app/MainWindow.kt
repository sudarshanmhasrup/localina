package com.desktop.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import com.compose.app.DesktopApp
import kotlin.system.exitProcess

@Composable
fun MainWindow() {
    Window(title = "Localina Desktop Example", onCloseRequest = { exitProcess(status = 0) }) {
        DesktopApp()
    }
}