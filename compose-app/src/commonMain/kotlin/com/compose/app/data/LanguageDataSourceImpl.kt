package com.compose.app.data

import com.compose.app.domain.model.Language
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

internal class LanguageDataSourceImpl : LanguageDataSource {
    private val languageList = MutableStateFlow(
        value = listOf(
            Language(
                name = "English",
                message = "Use this app in English.",
                locale = "en",
                isSelected = true
            ),
            Language(
                name = "Marathi",
                message = "हे अ‍ॅप मराठीत वापरा.",
                locale = "mr",
                isSelected = false
            ),
            Language(
                name = "Hindi",
                message = "इस ऐप का उपयोग हिंदी में करें।",
                locale = "hi",
                isSelected = false
            )
        )
    )

    override fun getLanguages(): StateFlow<List<Language>> {
        return languageList
    }

    override fun updateSelectedLanguage(language: Language) {
        languageList.update { value ->
            value.map {
                if (it.locale == language.locale) {
                    language.copy(isSelected = true)
                } else {
                    it.copy(isSelected = false)
                }
            }
        }
    }
}