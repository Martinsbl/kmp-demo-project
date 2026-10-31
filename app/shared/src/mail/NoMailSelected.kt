package org.example.demo.mail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NoMailSelected() {
    // Unlike the screens, the placeholder has no Scaffold, so the Surface gives it the theme's background and text color.
    Surface(Modifier.fillMaxSize()) {
        // The template avoids centered text, so the hint sits at the start of the pane.
        Box(Modifier.fillMaxSize().padding(24.dp), contentAlignment = Alignment.CenterStart) {
            Text("Select a mail to read", style = MaterialTheme.typography.titleMedium)
        }
    }
}
