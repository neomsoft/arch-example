package arch.example

import androidx.compose.runtime.Composable
import arch.example.ui.theme.ArchExampleTheme
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.ksp.generated.module

/**
 * Called when app starts.
 */
fun initApp(
    koinPlatformConfig: KoinAppDeclaration = {},
) {
    startKoin {
        koinPlatformConfig(this)
        modules(AppModule().module)
    }
}

/**
 * Called when ui starts.
 */
@Composable
fun ComposeApp() {
    ArchExampleTheme {
    }
}