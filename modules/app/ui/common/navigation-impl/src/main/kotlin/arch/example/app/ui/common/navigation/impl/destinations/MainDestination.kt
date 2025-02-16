package arch.example.app.ui.common.navigation.impl.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import arch.example.app.ui.common.navigation.impl.Route
import arch.example.app.ui.screens.main.MainScreen
import com.github.terrakok.cicerone.compose.ComposeScreen
import io.github.neomsoft.navigation.compose.destination.Destination

internal object MainDestination : Destination(name = Route.MAIN) {

    val composeScreen = ComposeScreen(route = route())

    @Composable
    override fun onDrawScreen(navBackStackEntry: NavBackStackEntry) {
        MainScreen()
    }
}