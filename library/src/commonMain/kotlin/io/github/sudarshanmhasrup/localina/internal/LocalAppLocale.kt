package io.github.sudarshanmhasrup.localina.internal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidedValue

internal expect object LocalAppLocale {
    @Composable
    infix fun provides(value: String?): ProvidedValue<*>
}