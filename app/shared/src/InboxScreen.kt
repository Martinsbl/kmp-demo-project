package org.example.demo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun InboxScreen(
    state: UiState<List<Email>>,
    onMailClick: (Int) -> Unit,
) {
    Scaffold(topBar = { BouvetTopBar(title = { Text("PENGUIN MAIL", fontWeight = FontWeight.Bold) }) }) { padding ->
        Box(Modifier
            .padding(padding)
            .fillMaxSize(), contentAlignment = Alignment.Center) {
            when (state) {
                UiState.Loading -> {
                    CircularProgressIndicator()
                }

                is UiState.Error -> {
                    Text(state.message, Modifier.align(Alignment.CenterStart).padding(16.dp))
                }

                is UiState.Success -> {
                    LazyColumn(Modifier.fillMaxSize()) {
                        items(state.data, key = { it.id }) { email ->
                            ListItem(
                                headlineContent = { Text(email.subject) },
                                overlineContent = { Text(email.from) },
                                supportingContent = {
                                    Text(email.body, maxLines = 1, overflow = TextOverflow.Ellipsis)
                                },
                                trailingContent = { Text(email.date) },
                                modifier = Modifier.clickable { onMailClick(email.id) },
                            )
                            HorizontalDivider(thickness = LineThickness)
                        }
                    }
                }
            }
        }
    }
}
