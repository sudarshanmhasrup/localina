package com.compose.app.presentation.extensions

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

internal fun Modifier.headingAndMessageModifier(isMobileLandscapeMode: Boolean = false): Modifier {
    val topPadding = if (isMobileLandscapeMode) 20.dp else 60.dp
    return this
        .fillMaxWidth()
        .padding(start = 20.dp, end = 20.dp, top = topPadding, bottom = 20.dp)
}