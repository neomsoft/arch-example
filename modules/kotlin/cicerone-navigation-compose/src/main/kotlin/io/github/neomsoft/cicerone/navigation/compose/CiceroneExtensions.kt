package io.github.neomsoft.cicerone.navigation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.navigation.NavHostController
import com.github.terrakok.cicerone.BaseRouter
import com.github.terrakok.cicerone.Cicerone
import io.github.neomsoft.compose.disposable.DisposableEffectWithLifecycle

@Composable
@NonRestartableComposable
fun <T: BaseRouter> Cicerone<T>.connectWithNavController(navController: NavHostController) {
    DisposableEffectWithLifecycle {
        onResume {
            val navigator = NavigatorImpl(navController = navController)
            getNavigatorHolder().setNavigator(navigator = navigator)
        }

        onPause {
            getNavigatorHolder().removeNavigator()
        }
    }
}
