package org.example.demo.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance

/** A top bar with the template's orange rule under it. Icons are white on navy, navy on cream, never orange. */
@Composable
fun BouvetTopBar(
    title: @Composable () -> Unit,
    navigationIcon: @Composable () -> Unit = {},
) {
    val colors = MaterialTheme.colorScheme
    val iconColor = if (colors.background.luminance() < 0.5f) Color.White else colors.onSurface
    Column {
        TopAppBar(
            title = title,
            navigationIcon = navigationIcon,
            colors =
            TopAppBarDefaults.topAppBarColors(
                navigationIconContentColor = iconColor,
                actionIconContentColor = iconColor,
            ),
        )
        HorizontalDivider(thickness = LineThickness, color = MaterialTheme.colorScheme.outline)
    }
}
