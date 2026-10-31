package org.example.demo.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/** A top bar with the template's orange rule under it. Icons are white, never orange. */
@Composable
fun BouvetTopBar(
    title: @Composable () -> Unit,
    navigationIcon: @Composable () -> Unit = {},
) {
    Column {
        TopAppBar(
            title = title,
            navigationIcon = navigationIcon,
            colors =
                TopAppBarDefaults.topAppBarColors(
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White,
                ),
        )
        HorizontalDivider(thickness = LineThickness, color = MaterialTheme.colorScheme.outline)
    }
}
