package arch.example.app.ui.screens.onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import arch.example.app.ui.common.design.R
import arch.example.app.ui.common.design.theme.AppTheme
import arch.example.app.ui.screens.onboarding.elements.OnboardingItem
import arch.example.app.ui.screens.onboarding.elements.PagerIndicators
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun OnboardingScreen() {
    val viewModel = koinViewModel<OnboardingViewModel>()

    Screen(callback = viewModel)
}

@Composable
internal fun Screen(
    callback: ScreenCallback,
) {
    val items = remember { OnboardingItem.getData() }
    val pagerState = rememberPagerState { items.size }

    Scaffold(
        containerColor = AppTheme.colorScheme.surface,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {
            TextButton(
                onClick = callback::onBtnSkipClick,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 16.dp),
            ) {
                Text(
                    text = stringResource(R.string.skip),
                )
            }

            HorizontalPager(
                state = pagerState,
                modifier = Modifier.weight(1f),
            ) {
                OnboardingItem(item = items[it])
            }

            PagerIndicators(
                state = pagerState,
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .align(Alignment.CenterHorizontally),
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    val callback = object : ScreenCallback {
        override fun onBtnSkipClick() = Unit
    }

    AppTheme {
        Screen(callback = callback)
    }
}