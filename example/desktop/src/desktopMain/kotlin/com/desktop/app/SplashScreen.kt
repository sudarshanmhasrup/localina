package com.desktop.app

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.sudarshanmhasrup.splashify.ui.config.SplashIndicatorStyle
import io.github.sudarshanmhasrup.splashify.ui.config.SplashScreenSize
import io.github.sudarshanmhasrup.splashify.ui.config.SplashScreenStyle
import io.github.sudarshanmhasrup.splashify.ui.splashscreen.ProgressiveSplashScreen

@Composable
fun SplashScreen() {
    val size = SplashScreenSize(width = 600.dp, height = 380.dp)
    val style = SplashScreenStyle(cornerRadius = 16.dp, backgroundColor = Color.Black)
    val indicatorStyle = SplashIndicatorStyle(color = Color.White, trackColor = Color.Black, thickness = 2.dp)

    ProgressiveSplashScreen(size = size, style = style, indicatorStyle = indicatorStyle) {
        Text(text = "Localina", fontSize = 28.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
    }
}