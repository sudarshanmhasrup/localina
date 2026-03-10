package com.compose.app.presentation.composeApp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.compose.app.presentation.components.HeadingAndMessage
import com.compose.app.presentation.components.LanguageCard
import com.compose.app.presentation.extensions.backgroundModifier
import com.compose.app.presentation.extensions.headingAndMessageModifier
import com.compose.app.presentation.theme.ComposeAppTheme
import com.compose.app.resources.Res
import com.compose.app.resources.language_page_heading
import com.compose.app.resources.language_page_message
import io.github.sudarshanmhasrup.localina.api.LocalinaApp
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ComposeApp() {
    ComposeAppTheme {
        LocalinaApp {
            val backgroundColor = MaterialTheme.colorScheme.background
            Column(modifier = Modifier.backgroundModifier(backgroundColor = backgroundColor)) {
                LanguagePage(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
private fun LanguagePage(modifier: Modifier = Modifier) {
    val composeAppViewModel = koinViewModel<ComposeAppViewModel>()
    Column(modifier = modifier) {
        HeadingAndMessage(
            heading = Res.string.language_page_heading,
            message = Res.string.language_page_message,
            modifier = Modifier.headingAndMessageModifier()
        )
        LanguageList(composeAppViewModel = composeAppViewModel, modifier = Modifier.fillMaxSize())
    }
}

@Composable
private fun LanguageList(
    composeAppViewModel: ComposeAppViewModel,
    modifier: Modifier = Modifier
) {
    val uiState = composeAppViewModel.uiState.collectAsStateWithLifecycle()
    val languages = uiState.value.languages

    LazyColumn(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(items = languages) { language ->
            LanguageCard(
                language = language,
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    composeAppViewModel.updateSelectedLanguage(language = language)
                }
            )
        }
    }
}