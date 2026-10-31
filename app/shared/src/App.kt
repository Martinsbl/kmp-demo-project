package org.example.demo

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfoV2
import androidx.compose.material3.adaptive.layout.calculatePaneScaffoldDirective
import androidx.compose.material3.adaptive.navigation3.ListDetailSceneStrategy
import androidx.compose.material3.adaptive.navigation3.rememberListDetailSceneStrategy
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import org.example.demo.data.MailApi
import org.example.demo.inbox.Inbox
import org.example.demo.inbox.InboxScreen
import org.example.demo.inbox.InboxViewModel
import org.example.demo.mail.Mail
import org.example.demo.mail.MailScreen
import org.example.demo.mail.MailViewModel
import org.example.demo.mail.NoMailSelected
import org.example.demo.theme.BouvetTheme
import org.jetbrains.compose.reload.DevelopmentEntryPoint

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
@DevelopmentEntryPoint
fun App() {
    val api = remember { MailApi() }
    val backStack = rememberNavBackStack(navConfig, Inbox)

    // Wide windows (desktop, web, tablets) show the inbox and the mail side by side.
    val directive = calculatePaneScaffoldDirective(currentWindowAdaptiveInfoV2())
    val isSinglePane = directive.maxHorizontalPartitions == 1

    BouvetTheme {
        NavDisplay(
            backStack = backStack,
            // Fills the gap between the list and the mail, which would otherwise be left undrawn.
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
            onBack = { backStack.removeLastOrNull() },
            sceneStrategies = listOf(rememberListDetailSceneStrategy(directive = directive)),
            entryDecorators =
            listOf(
                rememberSaveableStateHolderNavEntryDecorator(),
                rememberViewModelStoreNavEntryDecorator(),
            ),
            entryProvider =
            entryProvider {
                entry<Inbox>(
                    metadata = ListDetailSceneStrategy.listPane(detailPlaceholder = { NoMailSelected() }),
                ) {
                    val viewModel = viewModel { InboxViewModel(api) }
                    val state by viewModel.state.collectAsStateWithLifecycle()
                    InboxScreen(
                        state = state,
                        onMailClick = { id ->
                            // Replace the open mail instead of stacking mails on top of each other.
                            if (backStack.last() is Mail) backStack.removeLastOrNull()
                            backStack.add(Mail(id))
                        },
                    )
                }
                entry<Mail>(metadata = ListDetailSceneStrategy.detailPane()) { mail ->
                    val viewModel = viewModel { MailViewModel(api, mail.id) }
                    val state by viewModel.state.collectAsStateWithLifecycle()
                    MailScreen(
                        state = state,
                        onBack = if (isSinglePane) ({ backStack.removeLastOrNull() }) else null,
                    )
                }
            },
        )
    }
}
