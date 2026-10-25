package org.example.demo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

class InboxViewModel(
    api: MailApi,
) : ViewModel() {
    val state: StateFlow<UiState<List<Email>>> =
        flow<UiState<List<Email>>> { emit(UiState.Success(api.emails())) }
            .catch { emit(UiState.Error("Could not reach the colony server: ${it.message}")) }
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), UiState.Loading)
}
