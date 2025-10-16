package com.compose.app.data

import com.compose.app.domain.model.Language
import kotlinx.coroutines.flow.StateFlow

internal interface LanguageDataSource {
    fun getLanguages(): StateFlow<List<Language>>
    fun updateSelectedLanguage(language: Language)
}