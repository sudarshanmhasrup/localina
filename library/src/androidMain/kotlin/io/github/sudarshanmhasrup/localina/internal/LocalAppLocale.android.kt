package io.github.sudarshanmhasrup.localina.internal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidedValue
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalResources
import java.util.Locale

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
internal actual object LocalAppLocale {
    private var defaultLocale: Locale? = null

    @Composable
    actual infix fun provides(value: String?): ProvidedValue<*> {
        val configuration = LocalConfiguration.current

        if (defaultLocale == null) {
            defaultLocale = Locale.getDefault()
        }

        val new = when (value) {
            null -> defaultLocale!!
            else -> Locale.forLanguageTag(value)
        }
        Locale.setDefault(new)
        configuration.setLocale(new)
        val resources = LocalResources.current

        resources.updateConfiguration(configuration, resources.displayMetrics)
        return LocalConfiguration.provides(configuration)
    }
}