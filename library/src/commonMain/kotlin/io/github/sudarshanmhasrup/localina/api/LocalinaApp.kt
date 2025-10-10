package io.github.sudarshanmhasrup.localina.api

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.key
import io.github.sudarshanmhasrup.localina.internal.LocalAppLocale

@Composable
fun LocalinaApp(content: @Composable () -> Unit) {
    val currentLocale = LocaleUpdater.getLocale().value
    CompositionLocalProvider(LocalAppLocale provides currentLocale) {
        key(currentLocale) {
            content()
        }
    }
}