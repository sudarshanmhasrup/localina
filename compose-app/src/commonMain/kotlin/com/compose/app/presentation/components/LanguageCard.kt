package com.compose.app.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.compose.app.domain.model.Language
import com.compose.app.presentation.theme.ComposeAppTheme
import io.github.sudarshanmhasrup.localina.api.Locale
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
internal fun LanguageCard(
    language: Language,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val commonModifier = Modifier.fillMaxWidth()
    val backgroundModifier = modifier
        .padding(horizontal = 20.dp)
        .background(color = MaterialTheme.colorScheme.background)
        .clip(shape = RoundedCornerShape(size = 12.dp))
        .clickable(onClick = onClick)
        .padding(vertical = 12.dp)
        .pointerHoverIcon(icon = PointerIcon.Hand)

    Row(verticalAlignment = Alignment.CenterVertically, modifier = backgroundModifier) {
        RadioButton(selected = language.isSelected, onClick = onClick)
        Spacer(modifier = Modifier.width(4.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = language.name,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                modifier = commonModifier
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = language.message,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Normal,
                modifier = commonModifier
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LanguageCardPreview() {
    ComposeAppTheme {
        val language = Language(
            name = "English",
            message = "Use this app in English",
            locale = Locale.English,
            isSelected = true
        )
        LanguageCard(language = language, modifier = Modifier.fillMaxWidth(), onClick = {})
    }
}