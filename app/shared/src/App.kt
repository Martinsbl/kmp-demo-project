package org.example.demo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfoV2
import androidx.compose.material3.adaptive.layout.calculatePaneScaffoldDirective
import androidx.compose.material3.adaptive.navigation3.ListDetailSceneStrategy
import androidx.compose.material3.adaptive.navigation3.rememberListDetailSceneStrategy
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.Serializable
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import org.jetbrains.compose.reload.DevelopmentEntryPoint

@Serializable
data object Inbox : NavKey

@Serializable
data class Mail(
    val id: Int,
) : NavKey

// Lets the back stack be saved on non-Android platforms, where reflection is not available.
private val navConfig =
    SavedStateConfiguration {
        serializersModule =
            SerializersModule {
                polymorphic(NavKey::class) {
                    subclass(Inbox::class)
                    subclass(Mail::class)
                }
            }
    }

private val penguinColors =
    lightColorScheme(
        primary = Color(0xFF0B4F6C),
        primaryContainer = Color(0xFFCDE8F6),
        onPrimaryContainer = Color(0xFF00344A),
        background = Color(0xFFF4FAFD),
        surface = Color(0xFFF4FAFD),
    )

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
@Preview
@DevelopmentEntryPoint
fun App() {
    val api = remember { MailApi() }
    val backStack = rememberNavBackStack(navConfig, Inbox)

    // Wide windows (desktop, web, tablets) show the inbox and the mail side by side.
    val directive = calculatePaneScaffoldDirective(currentWindowAdaptiveInfoV2())
    val isSinglePane = directive.maxHorizontalPartitions == 1

    MaterialTheme(colorScheme = penguinColors) {
        NavDisplay(
            backStack = backStack,
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

@Composable
private fun NoMailSelected() {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Select a mail to read", style = MaterialTheme.typography.titleMedium)
    }
}
