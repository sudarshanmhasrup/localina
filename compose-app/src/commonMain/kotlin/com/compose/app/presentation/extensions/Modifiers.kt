package com.compose.app.presentation.extensions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
internal fun Modifier.backgroundModifier(backgroundColor: Color): Modifier {
    return this
        .fillMaxSize()
        .background(color = backgroundColor)
}

internal fun Modifier.headingAndMessageModifier(isMobileLandscapeMode: Boolean = false): Modifier {
    val topPadding = if (isMobileLandscapeMode) 20.dp else 60.dp
    return this
        .fillMaxWidth()
        .padding(start = 20.dp, end = 20.dp, top = topPadding, bottom = 20.dp)
}