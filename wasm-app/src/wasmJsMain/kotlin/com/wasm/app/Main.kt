package com.wasm.app

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.compose.app.WasmApp
import com.compose.app.di.initKoin
import kotlinx.browser.document
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initKoin()
    onWasmReady {
        val body = document.body ?: return@onWasmReady
        ComposeViewport(viewportContainer = body) {
            WasmApp()
        }
    }
}