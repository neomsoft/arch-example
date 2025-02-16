package arch.example.app.ui.screens.onboarding.elements

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import arch.example.app.ui.common.design.theme.AppTheme

@Composable
internal fun OnboardingItem(
    item: OnboardingItem,
    modifier: Modifier = Modifier,
) {
    val configuration = LocalConfiguration.current

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            LandscapeContent(item)
        } else {
            PortraitContent(item)
        }
    }
}

@Composable
@NonRestartableComposable
private fun PortraitContent(
    item: OnboardingItem,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = containerModifier,
    ) {
        ItemImage(item.image)

        Spacer(modifier = Modifier.height(16.dp))

        ItemText(item.text)
    }
}

@Composable
@NonRestartableComposable
private fun LandscapeContent(
    item: OnboardingItem,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = containerModifier,
    ) {
        ItemImage(item.image)

        Spacer(modifier = Modifier.width(16.dp))

        ItemText(item.text)
    }
}

@Composable
@NonRestartableComposable
private fun ItemImage(imageRes: Int) {
    Image(
        painter = painterResource(imageRes),
        contentDescription = null,
        modifier = Modifier.size(200.dp),
        contentScale = ContentScale.Fit,
    )
}

@Composable
@NonRestartableComposable
private fun ItemText(textRes: Int) {
    Text(
        text = stringResource(textRes),
        style = AppTheme.typography.titleLarge,
        color = AppTheme.colorScheme.onSurface,
        textAlign = TextAlign.Center,
        modifier = Modifier.width(250.dp),
    )
}

private val containerModifier
    get() = Modifier.padding(horizontal = 24.dp)

@Preview
@Composable
private fun Preview() {
    val item = OnboardingItem.getData().first()

    AppTheme {
        OnboardingItem(
            item = item,
            modifier = Modifier.background(color = Color.White),
        )
    }
}