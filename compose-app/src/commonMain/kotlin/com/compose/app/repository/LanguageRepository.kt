package com.compose.app.repository

import com.compose.app.domain.model.Language
import kotlinx.coroutines.flow.StateFlow

internal interface LanguageRepository {
    fun getLanguages(): StateFlow<List<Language>>
    fun updateSelectedLanguage(language: Language)
}