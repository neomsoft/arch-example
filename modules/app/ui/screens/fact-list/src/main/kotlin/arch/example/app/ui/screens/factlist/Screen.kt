package arch.example.app.ui.screens.factlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import arch.example.app.ui.common.design.R
import arch.example.app.ui.common.design.elements.buttons.BackButton
import arch.example.app.ui.common.design.elements.screen.ScreenContentContainer
import arch.example.app.ui.common.design.theme.AppTheme
import io.github.neomsoft.flow.result.FlowResult
import io.github.neomsoft.flow.result.toSuccessFlowResult
import org.koin.compose.viewmodel.koinViewModel

@Composable
@NonRestartableComposable
fun FactListScreen() {
    val viewModel = koinViewModel<FactListViewModel>()
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
                    Text(text = stringResource(R.string.fact_list_screen_title))
                },
                navigationIcon = {
                    BackButton(onClick = callback::onBtnBackClick)
                },
            )
        },
    ) { paddingValues ->
        ScreenContentContainer(
            state = stateFlow(),
            modifier = Modifier
                .padding(top = paddingValues.calculateTopPadding()),
        ) { state ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                contentPadding = PaddingValues(bottom = paddingValues.calculateBottomPadding()),
            ) {
                items(items = state.facts) {
                    Text(
                        text = it,
                        style = AppTheme.typography.bodyLarge,
                        modifier = Modifier
                            .background(color = AppTheme.colorScheme.surface)
                            .fillParentMaxWidth()
                            .padding(horizontal = 16.dp)
                            .padding(vertical = 8.dp),
                    )
                }
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

    val facts = listOf(
        "Cats are funny",
        "Cats eat mouses"
    )

    val state = ScreenState(facts = facts).toSuccessFlowResult()

    AppTheme {
        Screen(
            stateFlow = { state },
            callback = callback,
        )
    }
}