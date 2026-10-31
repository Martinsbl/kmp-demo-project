package org.example.demo.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun BouvetTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = bouvetColorScheme,
        typography = bouvetTypography(),
        shapes = bouvetShapes,
        content = content,
    )
}
