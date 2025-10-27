package com.compose.app.data

import com.compose.app.domain.model.Language
import io.github.sudarshanmhasrup.localina.annoations.ExperimentalLocalinaApi
import io.github.sudarshanmhasrup.localina.api.Locale
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

internal class LanguageDataSourceImpl : LanguageDataSource {
    @OptIn(ExperimentalLocalinaApi::class)
    private val languageList = MutableStateFlow(
        value = listOf(
            Language(
                name = "English",
                message = "Use this app in English.",
                locale = Locale.English,
                isSelected = true
            ),
            Language(
                name = "Hindi",
                message = "इस ऐप का उपयोग हिंदी में करें।",
                locale = Locale.Hindi,
                isSelected = false
            ),
            Language(
                name = "Marathi",
                message = "हे अ‍ॅप मराठीत वापरा.",
                locale = Locale.Marathi,
                isSelected = false
            )
        )
    )

    override fun getLanguages(): StateFlow<List<Language>> {
        return languageList
    }

    @OptIn(ExperimentalLocalinaApi::class)
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