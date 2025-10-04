package com.compose.app.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.app.domain.model.Language
import com.compose.app.domain.useCase.LanguageUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class ComposeAppViewModel(useCase: LanguageUseCase) : ViewModel() {
    var uiState = MutableStateFlow(value = ComposeAppUiState())
        private set

    init {
        viewModelScope.launch {
            useCase.getLanguages().collect { languages ->
                uiState.update { value ->
                    value.copy(languages = languages)
                }
            }
        }
    }

    fun updateSelectedLanguage(language: Language) {
        useCase.updateSelectedLanguage(language = language)
    }
}