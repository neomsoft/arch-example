package arch.example.app.ui.common.design.elements.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import arch.example.app.ui.common.design.R
import arch.example.app.ui.common.design.theme.AppTheme
import io.github.neomsoft.flow.result.FlowResult
import io.github.neomsoft.flow.result.onSuccess


@Composable
@NonRestartableComposable
fun <T> ScreenContentContainer(
    state: FlowResult<T>,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.(T) -> Unit,
) = ScreenContentContainer(
    state = ContentState.from(state),
    modifier = modifier,
    content = {
        state.onSuccess {
            content(it)
        }
    },
)

@Composable
fun ScreenContentContainer(
    state: ContentState,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit,
) {
    Content(
        state = state,
        content = content,
        modifier = modifier.fillMaxSize(),
    )
}

@Composable
private fun Content(
    state: ContentState,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit,
) {
    when (state) {
        ContentState.LoadingError -> {
            ContentWaitingBox(modifier = modifier) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_alert_triangle),
                        contentDescription = null,
                        tint = AppTheme.colorScheme.secondary,
                        modifier = Modifier.size(36.dp)
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = stringResource(id = R.string.content_loading_error_text),
                        textAlign = TextAlign.Center,
                        style = AppTheme.typography.headlineSmall,
                        color = AppTheme.colorScheme.secondary,
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = stringResource(id = R.string.content_loading_error_description),
                        textAlign = TextAlign.Center,
                        style = AppTheme.typography.bodyLarge,
                        color = AppTheme.colorScheme.secondary,
                    )
                }
            }
        }

        ContentState.Loading -> {
            ContentWaitingBox(modifier = modifier) {
                CircularProgressIndicator()
            }
        }

        ContentState.Loaded -> {
            Box(
                modifier = modifier,
                content = content,
            )
        }
    }
}

@Composable
private fun ContentWaitingBox(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .background(color = AppTheme.colorScheme.surface)
            .heightIn(min = WaitingBoxMinHeight)
            .padding(all = 25.dp),
        contentAlignment = Alignment.Center,
    ) {
        content()
    }
}

val WaitingBoxMinHeight = 180.dp

@Preview
@Composable
private fun Preview() {
    AppTheme {
        ScreenContentContainer(
            state = ContentState.LoadingError,
            content = {},
        )
    }
}