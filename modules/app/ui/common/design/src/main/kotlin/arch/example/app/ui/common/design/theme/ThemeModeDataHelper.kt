package arch.example.app.ui.common.design.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Typography
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalContext
import arch.example.app.core.entities.theme.ThemeMode

internal object ThemeModeDataHelper {

    @Composable
    @ReadOnlyComposable
    fun colorScheme(themeMode: ThemeMode): ColorScheme {
        return when (themeMode) {
            ThemeMode.Dark -> DarkColorScheme
            ThemeMode.Light -> LightColorScheme
            ThemeMode.System -> systemScheme()
            ThemeMode.SystemDynamic -> systemDynamicScheme()
        }
    }

    @Composable
    @ReadOnlyComposable
    private fun systemScheme(): ColorScheme {
        return if (isSystemInDarkTheme()) DarkColorScheme else LightColorScheme
    }

    @Composable
    @ReadOnlyComposable
    private fun systemDynamicScheme(): ColorScheme {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
            return systemScheme()
        }

        val darkTheme = isSystemInDarkTheme()
        val context = LocalContext.current

        return if (darkTheme) {
            dynamicDarkColorScheme(context)
        } else {
            dynamicLightColorScheme(context)
        }
    }


    fun typography(themeMode: ThemeMode): Typography {
        return when (themeMode) {
            ThemeMode.Dark -> Typography
            ThemeMode.Light -> Typography
            ThemeMode.System -> Typography
            ThemeMode.SystemDynamic -> Typography
        }
    }

    fun dimensions(themeMode: ThemeMode): AppDimensions {
        return when (themeMode) {
            ThemeMode.Dark -> Dimensions
            ThemeMode.Light -> Dimensions
            ThemeMode.System -> Dimensions
            ThemeMode.SystemDynamic -> Dimensions
        }
    }

    @Composable
    @ReadOnlyComposable
    fun isLightBars(themeMode: ThemeMode): Boolean {
        return when (themeMode) {
            ThemeMode.Dark -> false
            ThemeMode.Light -> true
            ThemeMode.System -> isSystemInDarkTheme().not()
            ThemeMode.SystemDynamic -> isSystemInDarkTheme().not()
        }
    }
}