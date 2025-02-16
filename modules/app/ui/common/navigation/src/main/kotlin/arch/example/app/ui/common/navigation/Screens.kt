package arch.example.app.ui.common.navigation

sealed interface Screens {

    data object Main : Screens

    data object Onboarding : Screens

    data object NewFact : Screens

    data object FactList : Screens
}