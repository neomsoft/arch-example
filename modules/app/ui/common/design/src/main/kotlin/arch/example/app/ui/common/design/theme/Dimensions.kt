package arch.example.app.ui.common.design.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

internal val Dimensions = AppDimensions()

@Immutable
data class AppDimensions internal constructor(
    val smallShapeCornerRadius: Dp = 2.dp,
    val mediumShapeCornerRadius: Dp = 4.dp,
    val largeShapeCornerRadius: Dp = 10.dp,

    val contentMargins: Dp = 16.dp,
    val toolbarIconSize: Dp = 32.dp,

    val contentBlockSpacingBetween: Dp = 32.dp,
    val contentItemHeaderMarginBottom: Dp = 24.dp,
    val contentItemSpacingBetween: Dp = 20.dp,

    val largeTextFieldHeight: Dp = 140.dp,
    val imageAspectRatio: Float = 0.70588f,
    val iconSize: Dp = 20.dp,
) {
    val minimumInteractiveComponentSize = 48.dp
}

internal fun AppDimensions.toShapes(): Shapes {
    return Shapes(
        small = RoundedCornerShape(smallShapeCornerRadius),
        medium = RoundedCornerShape(mediumShapeCornerRadius),
        large = RoundedCornerShape(largeShapeCornerRadius),
    )
}

internal val LocalAppDimensions = staticCompositionLocalOf { AppDimensions() }