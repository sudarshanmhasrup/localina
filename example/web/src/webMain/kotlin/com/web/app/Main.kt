package com.web.app

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.compose.app.WebApp
import com.compose.app.di.initKoin
import kotlinx.browser.document
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initKoin()
    onWasmReady {
        val app = document.getElementById(elementId = "app") ?: return@onWasmReady

        ComposeViewport(viewportContainer = app) {
            val loaderContainer = document.getElementById("loader-container")
            loaderContainer?.remove()

            WebApp()
        }
    }
}