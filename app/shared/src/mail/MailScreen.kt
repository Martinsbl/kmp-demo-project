package org.example.demo.mail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.demo.Email
import org.example.demo.common.UiState
import org.example.demo.theme.BouvetTopBar

/** [onBack] is null when the inbox is shown next to the mail, so no back button is needed. */
@Composable
fun MailScreen(
    state: UiState<Email>,
    onBack: (() -> Unit)?,
) {
    Scaffold(
        topBar = {
            BouvetTopBar(
                title = { Text((state as? UiState.Success)?.data?.from.orEmpty()) },
                navigationIcon = {
                    if (onBack != null) {
                        IconButton(onClick = onBack) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                        }
                    }
                },
            )
        },
    ) { padding ->
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
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        Text(state.data.subject, style = MaterialTheme.typography.headlineSmall)
                        Text(state.data.date, style = MaterialTheme.typography.labelMedium)
                        Text(state.data.body, style = MaterialTheme.typography.bodyLarge)
                    }
                }
            }
        }
    }
}
