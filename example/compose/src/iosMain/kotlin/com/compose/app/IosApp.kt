package com.compose.app

import androidx.compose.ui.window.ComposeUIViewController
import com.compose.app.di.initKoin
import com.compose.app.presentation.composeApp.ComposeApp

fun IosApp() = ComposeUIViewController(configure = { initKoin() }) {
    ComposeApp()
}