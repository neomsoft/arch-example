package arch.example.app.ui.common.navigation.impl

import arch.example.app.ui.common.navigation.Screens
import arch.example.app.ui.common.navigation.impl.destinations.FactListDestination
import arch.example.app.ui.common.navigation.impl.destinations.MainDestination
import arch.example.app.ui.common.navigation.impl.destinations.NewFactDestination
import arch.example.app.ui.common.navigation.impl.destinations.OnboardingDestination

// Add all destination
internal fun destinations() = listOf(
    MainDestination,
    OnboardingDestination,
    NewFactDestination,
    FactListDestination,
)

internal fun Screens.asComposeScreen() = when (this) {
    is Screens.Main -> MainDestination.composeScreen
    is Screens.NewFact -> NewFactDestination.composeScreen
    is Screens.FactList -> FactListDestination.composeScreen
    is Screens.Onboarding -> OnboardingDestination.composeScreen
}