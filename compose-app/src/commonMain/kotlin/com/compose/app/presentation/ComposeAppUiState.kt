package com.compose.app.presentation

import com.compose.app.domain.model.Language

internal data class ComposeAppUiState(
    val languages: List<Language> = emptyList()
)