package com.compose.app.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.compose.app.resources.*
import org.jetbrains.compose.resources.Font

@Composable
internal fun getTypography(): Typography {
    val poppins = FontFamily(
        Font(resource = Res.font.regular, weight = FontWeight.Normal),
        Font(resource = Res.font.medium, weight = FontWeight.Medium),
        Font(resource = Res.font.semibold, weight = FontWeight.SemiBold),
        Font(resource = Res.font.bold, weight = FontWeight.Bold)
    )

    return with(MaterialTheme.typography) {
        copy(
            displayLarge = displayLarge.copy(fontFamily = poppins),
            displayMedium = displayMedium.copy(fontFamily = poppins),
            displaySmall = displaySmall.copy(fontFamily = poppins),
            headlineLarge = headlineLarge.copy(fontFamily = poppins),
            headlineMedium = headlineMedium.copy(fontFamily = poppins),
            headlineSmall = headlineSmall.copy(fontFamily = poppins),
            titleLarge = titleLarge.copy(fontFamily = poppins),
            titleMedium = titleMedium.copy(fontFamily = poppins),
            titleSmall = titleSmall.copy(fontFamily = poppins),
            bodyLarge = bodyLarge.copy(fontFamily = poppins),
            bodyMedium = bodyMedium.copy(fontFamily = poppins),
            bodySmall = bodySmall.copy(fontFamily = poppins),
            labelLarge = labelLarge.copy(fontFamily = poppins),
            labelMedium = labelMedium.copy(fontFamily = poppins),
            labelSmall = labelSmall.copy(fontFamily = poppins)
        )
    }
}