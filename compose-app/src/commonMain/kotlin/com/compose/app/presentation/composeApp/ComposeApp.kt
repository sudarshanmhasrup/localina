package com.compose.app.presentation.composeApp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
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
                LanguagePage()
            }
        }
    }
}

@Composable
private fun LanguagePage(modifier: Modifier = Modifier) {
    val composeAppViewModel = koinViewModel<ComposeAppViewModel>()

    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
    val windowWidth = windowSizeClass.windowWidthSizeClass
    val windowHeight = windowSizeClass.windowHeightSizeClass

    // Detect mobile landscape mode
    val isMobileLandscapeMode = windowWidth == WindowWidthSizeClass.EXPANDED &&
            windowHeight in listOf(WindowHeightSizeClass.COMPACT, WindowHeightSizeClass.MEDIUM)

    if (isMobileLandscapeMode) {
        Row(modifier = modifier) {
            val modifier1 = Modifier
                .fillMaxHeight()
                .weight(0.8f)
            val modifier2 = Modifier
                .fillMaxHeight()
                .weight(1.2f)

            LandingPageLayout(
                isMobileLandscapeMode = true,
                composeAppViewModel = composeAppViewModel,
                modifier = modifier1,
                modifier2 = modifier2,
            )
        }
    } else {
        Column(modifier = modifier) {
            LandingPageLayout(
                isMobileLandscapeMode = false,
                composeAppViewModel = composeAppViewModel,
                modifier = Modifier.fillMaxWidth(),
                modifier2 = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
private fun LandingPageLayout(
    isMobileLandscapeMode: Boolean,
    composeAppViewModel: ComposeAppViewModel,
    modifier: Modifier = Modifier,
    modifier2: Modifier = Modifier
) {
    Box(modifier = modifier) {
        val backgroundModifier = if (isMobileLandscapeMode) {
            Modifier
                .headingAndMessageModifier(isMobileLandscapeMode = true)
                .align(alignment = Alignment.Center)
        } else {
            Modifier.headingAndMessageModifier()
        }
        HeadingAndMessage(
            heading = Res.string.language_page_heading,
            message = Res.string.language_page_message,
            modifier = backgroundModifier
        )
    }
    Box(modifier = modifier2) {
        val languageListModifier = if (isMobileLandscapeMode) {
            Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.Center)
        } else {
            Modifier.fillMaxSize()
        }
        LanguageList(composeAppViewModel = composeAppViewModel, modifier = languageListModifier)
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
                onClick = { composeAppViewModel.updateSelectedLanguage(language) }
            )
        }
    }
}