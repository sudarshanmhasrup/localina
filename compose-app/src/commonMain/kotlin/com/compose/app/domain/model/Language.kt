package com.compose.app.domain.model

internal data class Language(
    val name: String,
    val message: String,
    val locale: String,
    val isSelected: Boolean
)