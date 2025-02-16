package arch.example.app.ui.screens.newfact

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import arch.example.app.ui.common.design.elements.buttons.BackButton
import arch.example.app.ui.common.design.elements.screen.ScreenContentContainer
import arch.example.app.ui.common.design.R
import arch.example.app.ui.common.design.theme.AppTheme
import io.github.neomsoft.flow.result.FlowResult
import io.github.neomsoft.flow.result.toSuccessFlowResult
import org.koin.compose.viewmodel.koinViewModel

@Composable
@NonRestartableComposable
fun NewFactScreen() {
    val viewModel = koinViewModel<NewFactViewModel>()
    val state = viewModel.state.collectAsStateWithLifecycle()

    Screen(
        stateFlow = { state.value },
        callback = viewModel,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun Screen(
    stateFlow: () -> FlowResult<ScreenState>,
    callback: ScreenCallback,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.new_fact_screen_title))
                },
                navigationIcon = {
                    BackButton(onClick = callback::onBtnBackClick)
                },
            )
        },
        containerColor = AppTheme.colorScheme.surface,
    ) { paddingValues ->
        ScreenContentContainer(
            state = stateFlow(),
            modifier = Modifier.padding(paddingValues),
        ) { state ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = state.fact,
                    style = AppTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    val callback = object : ScreenCallback {
        override fun onBtnBackClick() = Unit
    }

    val state = ScreenState(fact = "Cats are funny").toSuccessFlowResult()

    AppTheme {
        Screen(
            stateFlow = { state },
            callback = callback,
        )
    }
}