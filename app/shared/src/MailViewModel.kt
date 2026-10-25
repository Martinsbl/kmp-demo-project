package org.example.demo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

class MailViewModel(
    api: MailApi,
    id: Int,
) : ViewModel() {
    val state: StateFlow<UiState<Email>> =
        flow<UiState<Email>> { emit(UiState.Success(api.email(id))) }
            .catch { emit(UiState.Error("Could not fetch the mail: ${it.message}")) }
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), UiState.Loading)
}
