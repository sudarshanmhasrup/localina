package io.github.sudarshanmhasrup.localina.api

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.key
import io.github.sudarshanmhasrup.localina.internal.LocalAppLocale


/**
 * The root composable of the Localina library.
 *
 * Wrap your app's UI inside `LocalinaApp` to enable real-time
 * locale updates across all composables.
 *
 * Whenever the locale is updated using [LocaleUpdater.updateLocale],
 * the UI inside this composable automatically recomposes with the
 * new language.
 *
 * Example:
 * ```
 * @Composable
 * fun App() {
 *     LocalinaApp {
 *         // Your app UI here
 *     }
 * }
 * ```
 *
 * @param content The composable content of your app.
 */
@Composable
fun LocalinaApp(content: @Composable () -> Unit) {
    val currentLocale = LocaleUpdater.getLocale().value
    CompositionLocalProvider(LocalAppLocale provides currentLocale) {
        key(currentLocale) {
            content()
        }
    }
}