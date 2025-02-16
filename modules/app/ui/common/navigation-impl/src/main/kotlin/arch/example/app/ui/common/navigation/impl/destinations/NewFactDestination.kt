package arch.example.app.ui.common.navigation.impl.destinations

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import arch.example.app.ui.common.navigation.impl.Route
import arch.example.app.ui.screens.newfact.NewFactScreen
import com.github.terrakok.cicerone.compose.ComposeScreen
import io.github.neomsoft.navigation.compose.destination.Destination

internal object NewFactDestination : Destination(name = Route.NEW_FACT) {

    val composeScreen = ComposeScreen(route = route())

    @Composable
    override fun onDrawScreen(navBackStackEntry: NavBackStackEntry) {
        NewFactScreen()
    }
}