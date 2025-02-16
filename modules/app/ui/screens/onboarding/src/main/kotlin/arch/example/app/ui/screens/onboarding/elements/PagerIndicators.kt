package arch.example.app.ui.screens.onboarding.elements

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import arch.example.app.ui.common.design.theme.AppTheme

@Composable
internal fun PagerIndicators(
    state: PagerState,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(IndicatorSize),
    ) {
        repeat(times = state.pageCount) {
            Indicator(it == state.currentPage)
        }
    }
}

@Composable
private fun Indicator(selected: Boolean) {
    val width = if (selected) {
        IndicatorSize * 2
    } else {
        IndicatorSize
    }

    val color = if (selected) {
        AppTheme.colorScheme.primary
    } else {
        AppTheme.colorScheme.secondary
    }

    val widthAnim by animateDpAsState(width)
    val colorAnim by animateColorAsState(color)

    Box(
        modifier = Modifier
            .background(
                color = colorAnim,
                shape = CircleShape,
            )
            .height(IndicatorSize)
            .width(widthAnim),
    )
}

private val IndicatorSize = 8.dp

@Preview
@Composable
private fun Preview() {
    val state = rememberPagerState { 3 }

    AppTheme {
        PagerIndicators(
            state = state,
            modifier = Modifier.background(color = Color.White),
        )
    }
}