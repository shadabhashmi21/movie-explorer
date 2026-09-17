package com.example.movieexplorer.core.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val MovieDarkColorScheme = darkColorScheme(
    primary = Color(0xFFFFC107),
    onPrimary = Color(0xFF151515),

    background = Color(0xFF08090A),
    onBackground = Color(0xFFF5F5F5),

    surface = Color(0xFF151719),
    onSurface = Color(0xFFF5F5F5),

    surfaceVariant = Color(0xFF202326),
    onSurfaceVariant = Color(0xFFB8BEC5),

    secondary = Color(0xFF9FA8B0),
    onSecondary = Color(0xFF101214),

    error = Color(0xFFFF6B6B),
    onError = Color(0xFF210000)
)

@Composable
fun MovieExplorerTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = MovieDarkColorScheme,
        content = content
    )
}