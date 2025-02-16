package arch.example.app.ui.common.navigation.impl.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import arch.example.app.ui.common.navigation.impl.Route
import arch.example.app.ui.screens.onboarding.OnboardingScreen
import com.github.terrakok.cicerone.compose.ComposeScreen
import io.github.neomsoft.navigation.compose.destination.Destination

internal object OnboardingDestination : Destination(name = Route.ONBOARDING){

    val composeScreen = ComposeScreen(route = route())

    @Composable
    override fun onDrawScreen(navBackStackEntry: NavBackStackEntry) {
        OnboardingScreen()
    }
}