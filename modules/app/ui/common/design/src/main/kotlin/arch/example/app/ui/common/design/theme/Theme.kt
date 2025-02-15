package arch.example.app.ui.common.design.theme

import android.app.Activity
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat.getInsetsController
import arch.example.app.core.entities.theme.ThemeMode

@Composable
fun AppTheme(
    themeMode: ThemeMode = ThemeMode.SystemDynamic,
    content: @Composable () -> Unit
) {
    val colorScheme = ThemeModeDataHelper.colorScheme(themeMode)
    val isLightBars = ThemeModeDataHelper.isLightBars(themeMode)
    val dimensions = ThemeModeDataHelper.dimensions(themeMode)
    val typography = ThemeModeDataHelper.typography(themeMode)
    val shapes = remember(key1 = dimensions) { dimensions.toShapes() }

    val view = LocalView.current

    if (view.isInEditMode.not()) {
        SideEffect {
            val window = (view.context as Activity).window
            val controller = getInsetsController(window, view)

            controller.isAppearanceLightStatusBars = isLightBars
            controller.isAppearanceLightNavigationBars = isLightBars
        }
    }

    CompositionLocalProvider(
        LocalAppDimensions provides dimensions,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = typography,
            shapes = shapes,
            content = content,
        )
    }
}

object AppTheme {

    val colorScheme: ColorScheme
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.colorScheme

    val dimens: AppDimensions
        @Composable
        @ReadOnlyComposable
        get() = LocalAppDimensions.current

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.typography

    val shapes: Shapes
        @Composable
        @ReadOnlyComposable
        get() = MaterialTheme.shapes
}