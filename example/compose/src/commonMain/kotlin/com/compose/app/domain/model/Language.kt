package com.compose.app.domain.model

import io.github.sudarshanmhasrup.localina.annoations.ExperimentalLocalinaApi
import io.github.sudarshanmhasrup.localina.api.Locale

internal data class Language @OptIn(ExperimentalLocalinaApi::class) constructor(
    val name: String,
    val message: String,
    val locale: Locale,
    val isSelected: Boolean
)