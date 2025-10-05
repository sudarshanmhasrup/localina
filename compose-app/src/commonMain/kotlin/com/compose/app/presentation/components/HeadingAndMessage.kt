package com.compose.app.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.compose.app.presentation.extensions.headingAndMessageModifier
import com.compose.app.presentation.theme.ComposeAppTheme
import com.compose.app.resources.Res
import com.compose.app.resources.language_page_heading
import com.compose.app.resources.language_page_message
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
internal fun HeadingAndMessage(
    heading: StringResource,
    message: StringResource,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(resource = heading),
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.headlineLarge,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(resource = message),
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HeadingAndMessagePreview() {
    ComposeAppTheme {
        HeadingAndMessage(
            heading = Res.string.language_page_heading,
            message = Res.string.language_page_message,
            modifier = Modifier.headingAndMessageModifier()
        )
    }
}