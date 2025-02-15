package arch.example

import androidx.compose.runtime.Immutable
import arch.example.app.core.entities.theme.ThemeMode

@Immutable
internal data class ComposeAppState(
    val onboardingShown: Boolean,
    val themeMode: ThemeMode,
)