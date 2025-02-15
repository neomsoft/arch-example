package arch.example

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import arch.example.app.ui.common.design.theme.AppTheme
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

    state.onSuccess {
        LaunchedEffect(key1 = null) {
            onContentLoaded()
        }

        AppTheme(themeMode = it.themeMode) {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Text(
                    text = "Hello Android!",
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}