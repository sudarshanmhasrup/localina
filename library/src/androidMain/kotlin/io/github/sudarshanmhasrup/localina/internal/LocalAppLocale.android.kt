package io.github.sudarshanmhasrup.localina.internal

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidedValue
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import java.util.Locale

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
internal actual object LocalAppLocale {
    private var defaultLocale: Locale? = null

    @Composable
    actual infix fun provides(value: String?): ProvidedValue<*> {
        val context = LocalContext.current
        val currentConfig = LocalConfiguration.current

        if (defaultLocale == null) {
            defaultLocale = Locale.getDefault()
        }

        val newLocale = when (value) {
            null -> defaultLocale!!
            else -> Locale.forLanguageTag(value)
        }
        Locale.setDefault(newLocale)

        val newConfig = Configuration(currentConfig).apply {
            setLocale(newLocale)
        }
        context.createConfigurationContext(newConfig)

        return LocalConfiguration.provides(newConfig)
    }
}
