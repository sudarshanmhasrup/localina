package io.github.sudarshanmhasrup.localina.api

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

object LocaleUpdater {
    private var locale = mutableStateOf<String?>(null)

    internal fun getLocale(): MutableState<String?> {
        return locale
    }

    fun updateLocale(locale: String) {
        this.locale.value = locale
    }
}