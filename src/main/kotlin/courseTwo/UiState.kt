package org.example.courseTwo

sealed class UiState {
    // Loading state
    object Loading: UiState()

    // Loaded
    data class Loaded(val title: String, val subtitle: String): UiState()

    // Error
    class Error(val error: Throwable): UiState()
}