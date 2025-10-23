package io.github.sudarshanmhasrup.localina.api

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

/**
 * A singleton object that manages and updates the current locale for your Compose Multiplatform app in real time.
 *
 * Example usage:
 * ```
 * // Change the app language to Hindi using locale code
 * LocaleUpdater.updateLocale(locale = "hi")
 *
 * // Or change using the Locale enum
 * LocaleUpdater.updateLocale(locale = Locale.English)
 * ```
 */
public object LocaleUpdater {
    private var locale = mutableStateOf<String?>(null)

    internal fun getLocale(): MutableState<String?> {
        return locale
    }

    /**
     * Updates the current locale of the app.
     *
     * @param locale The locale code to switch to (e.g., "en", "hi", "fr").
     */
    public fun updateLocale(locale: String) {
        this.locale.value = locale
    }

    /**
     * Changes the app's language to the given [Locale] enum value.
     *
     * @param locale The language enum to switch to.
     */
    public fun updateLocale(locale: Locale) {
        this.locale.value = locale.code
    }
}