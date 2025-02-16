package arch.example.app.ui.screens.factlist

import androidx.compose.runtime.Immutable

@Immutable
internal data class ScreenState(
    val facts: List<String>,
)