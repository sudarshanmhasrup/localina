package io.github.sudarshanmhasrup.localina.internal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.intl.Locale
import io.github.sudarshanmhasrup.localina.external.window

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
internal actual object LocalAppLocale {
    private val LocalAppLocale = staticCompositionLocalOf { Locale.current }

    @Composable
    actual infix fun provides(value: String?): ProvidedValue<*> {
        window.__customLocale = value?.replace('_', '-')
        return LocalAppLocale.provides(Locale.current)
    }
}