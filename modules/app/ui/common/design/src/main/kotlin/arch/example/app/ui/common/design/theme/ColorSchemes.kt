package arch.example.app.ui.common.design.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme

internal val DarkColorScheme = darkColorScheme(
    primary = OriolesOrange,
    secondary = Gunmetal,
    background = VampireBlack,
    surface = ChineseBlack,
    error = CandyAppleRed,
    onPrimary = White,
    onSecondary = White,
    onBackground = White,
    onSurface = White,
    onError = White,
)

internal val LightColorScheme = lightColorScheme(
    primary = OriolesOrange,
    secondary = AntiFlashWhite,
    background = AntiFlashWhite,
    surface = White,
    error = CandyAppleRed,
    onPrimary = White,
    onSecondary = DarkGunmetal,
    onBackground = DarkGunmetal,
    onSurface = Gunmetal,
    onError = White,
)