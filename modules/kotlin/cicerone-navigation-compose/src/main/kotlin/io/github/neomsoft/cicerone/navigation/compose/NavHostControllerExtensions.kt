package io.github.neomsoft.cicerone.navigation.compose

import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder

internal fun NavHostController.navigateSingleTopTo(
    route: String,
    builder: (NavOptionsBuilder.() -> Unit)? = null
) {
    navigate(route = route) {
        launchSingleTop = true

        if (builder != null) builder()
    }
}

internal fun NavHostController.backTo(route: String?) {
    if (route != null) {
        popBackStack(route, false)
    } else {
        val backStack = currentBackStack.value
        val firstDestinationRoute = backStack.firstOrNull()?.destination?.route

        if (firstDestinationRoute != null) {
            popBackStack(firstDestinationRoute, false)
        }
    }
}
