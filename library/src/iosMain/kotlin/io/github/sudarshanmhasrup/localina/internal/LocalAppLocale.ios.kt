package io.github.sudarshanmhasrup.localina.internal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.staticCompositionLocalOf
import platform.Foundation.NSLocale
import platform.Foundation.NSUserDefaults
import platform.Foundation.preferredLanguages

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
internal actual object LocalAppLocale {
    private const val LANG_KEY = "AppleLanguages"
    private val default = NSLocale.preferredLanguages.first() as String
    private val localAppLocale = staticCompositionLocalOf { default }

    @Composable
    actual infix fun provides(value: String?): ProvidedValue<*> {
        val newLocale = value ?: default
        if (value == null) {
            NSUserDefaults.standardUserDefaults.removeObjectForKey(LANG_KEY)
        } else {
            NSUserDefaults.standardUserDefaults.setObject(arrayListOf(newLocale), LANG_KEY)
        }
        return localAppLocale.provides(newLocale)
    }
}