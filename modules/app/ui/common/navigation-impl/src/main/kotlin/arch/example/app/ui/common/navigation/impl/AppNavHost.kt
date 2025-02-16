package arch.example.app.ui.common.navigation.impl

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import arch.example.app.ui.common.navigation.impl.destinations.MainDestination
import arch.example.app.ui.common.navigation.impl.destinations.OnboardingDestination
import io.github.neomsoft.cicerone.navigation.compose.connectWithNavController
import io.github.neomsoft.navigation.compose.destination.NavigationHost

@Composable
fun AppNavHost(
    onboardingShown: Boolean,
    navController: NavHostController,
) {
    val destinations = destinations()
    val startDestination = if (onboardingShown) MainDestination else OnboardingDestination

    NavigationHost(
        navController = navController,
        startDestination = startDestination,
        destinations = destinations,
    )

    appRouter.cicerone.connectWithNavController(navController)
}