package com.compose.app.domain.useCase

import com.compose.app.domain.model.Language
import com.compose.app.repository.LanguageRepository
import kotlinx.coroutines.flow.StateFlow

internal class LanguageUseCase(private val repository: LanguageRepository) {
    fun getLanguages(): StateFlow<List<Language>> {
        return repository.getLanguages()
    }

    fun updateSelectedLanguage(language: Language) {
        repository.updateSelectedLanguage(language = language)
    }
}