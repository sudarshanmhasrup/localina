package com.compose.app.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val lightColorScheme = lightColorScheme(
    background = backgroundColorLight,
    primary = primaryColorCommon,
    onSurface = primaryFontColorLight,
    onSurfaceVariant = secondaryFontColorLight,
)

private val darkColorScheme = darkColorScheme(
    background = backgroundColorDark,
    onSurface = primaryFontColorDark,
    onSurfaceVariant = secondaryFontColorDark,
)

@Composable
internal fun ComposeAppTheme(
    isDarkMode: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (isDarkMode) darkColorScheme else lightColorScheme
    val typography = getTypography()

    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        content = content
    )
}