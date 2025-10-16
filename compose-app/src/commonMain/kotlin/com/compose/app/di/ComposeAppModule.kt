package com.compose.app.di

import com.compose.app.data.LanguageDataSource
import com.compose.app.data.LanguageDataSourceImpl
import com.compose.app.domain.useCase.LanguageUseCase
import com.compose.app.presentation.composeApp.ComposeAppViewModel
import com.compose.app.repository.LanguageRepository
import com.compose.app.repository.LanguageRepositoryImpl
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal val composeAppModule = module {
    singleOf(::LanguageDataSourceImpl).bind<LanguageDataSource>()
    singleOf(::LanguageRepositoryImpl).bind<LanguageRepository>()
    singleOf(::LanguageUseCase)
    viewModelOf(::ComposeAppViewModel)
}