package arch.example.app.ui.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import arch.example.app.ui.common.design.elements.buttons.LargePrimaryOutlinedButton
import arch.example.app.ui.common.design.theme.AppTheme
import arch.example.app.ui.common.design.R
import org.koin.compose.viewmodel.koinViewModel

@Composable
@NonRestartableComposable
fun MainScreen() {
    val viewModel = koinViewModel<MainViewModel>()

    Screen(callback = viewModel)
}

@Composable
internal fun Screen(
    callback: ScreenCallback,
) {
    Scaffold(
        containerColor = AppTheme.colorScheme.surface,
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                LargePrimaryOutlinedButton(
                    onClick = callback::onBtnGetNewFactClick,
                    text = stringResource(R.string.get_fact),
                )

                Spacer(modifier = Modifier.height(16.dp))

                LargePrimaryOutlinedButton(
                    onClick = callback::onBtnFactListClick,
                    text = stringResource(R.string.fact_list),
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    val callback = object : ScreenCallback {
        override fun onBtnGetNewFactClick() = Unit
        override fun onBtnFactListClick() = Unit
    }

    AppTheme {
        Screen(callback = callback)
    }
}