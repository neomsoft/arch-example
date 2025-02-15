package arch.example.app.ui.common.design.elements.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import arch.example.app.ui.common.design.theme.AppTheme

@Composable
@NonRestartableComposable
fun LargePrimaryOutlinedButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) = LargePrimaryOutlinedButton(
    onClick = onClick,
    modifier = modifier,
    enabled = enabled,
    content = { Text(text = text) },
)

@Composable
@NonRestartableComposable
fun LargePrimaryOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit
) = OutlinedButton(
    onClick = onClick,
    modifier = modifier
        .sizeIn(minHeight = AppTheme.dimens.minimumInteractiveComponentSize),
    enabled = enabled,
    colors = ButtonDefaults.outlinedButtonColors(
        contentColor = AppTheme.colorScheme.primary,
        disabledContentColor = AppTheme.colorScheme.onSurface.copy(alpha = 0.38f),
    ),
    border = BorderStroke(
        width = 1.0.dp,
        color = if (enabled) {
            AppTheme.colorScheme.primary
        } else {
            AppTheme.colorScheme.onSurface.copy(alpha = 0.12f)
        },
    ),
    content = content,
)

@Preview
@Composable
private fun Preview() {
    AppTheme {
        LargePrimaryOutlinedButton(
            onClick = {},
            text = "Button",
        )
    }
}