package org.example.demo.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun BouvetTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) bouvetDarkColorScheme else bouvetLightColorScheme,
        typography = bouvetTypography(),
        shapes = bouvetShapes,
        content = content,
    )
}
