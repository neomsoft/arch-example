package io.github.neomsoft.navigation.compose.destination

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog

@Composable
fun NavigationHost(
    navController: NavHostController,
    startDestination: Destination,
    destinations: List<Destination>,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination.route,
        modifier = modifier
    ) {
        destinations.forEach { destination ->
            if (destination.isDialog) {
                dialog(
                    route = destination.route,
                    arguments = destination.arguments,
                    deepLinks = destination.deepLinks,
                    dialogProperties = DialogProperties(usePlatformDefaultWidth = false),
                ) {
                    destination.drawScreen(navBackStackEntry = it)
                }
            } else {
                composable(
                    route = destination.route,
                    arguments = destination.arguments,
                    deepLinks = destination.deepLinks,
                ) {
                    destination.drawScreen(navBackStackEntry = it)
                }
            }
        }
    }
}
