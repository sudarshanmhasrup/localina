package com.compose.app.repository

import com.compose.app.data.LanguageDataSource
import com.compose.app.domain.model.Language
import kotlinx.coroutines.flow.StateFlow

internal class LanguageRepositoryImpl(private val dataSource: LanguageDataSource) : LanguageRepository {
    override fun getLanguages(): StateFlow<List<Language>> {
        return dataSource.getLanguages()
    }

    override fun updateSelectedLanguage(language: Language) {
        dataSource.updateSelectedLanguage(language = language)
    }
}