package arch.example

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import arch.example.app.ui.common.design.theme.AppTheme
import arch.example.app.ui.common.navigation.impl.AppNavHost
import io.github.neomsoft.flow.result.onSuccess
import org.koin.compose.viewmodel.koinViewModel
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
fun ComposeApp(onContentLoaded: () -> Unit) {
    val viewModel = koinViewModel<ComposeAppViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val navController = rememberNavController()

    state.onSuccess {
        LaunchedEffect(key1 = null) {
            onContentLoaded()
        }

        AppTheme(themeMode = it.themeMode) {
            AppNavHost(
                onboardingShown = it.onboardingShown,
                navController = navController,
            )
        }
    }
}