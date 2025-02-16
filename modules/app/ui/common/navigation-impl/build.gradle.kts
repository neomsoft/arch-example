plugins {
    id(plugin.local.platform)
    id(plugin.local.coroutines)
    id(plugin.local.koin)
    id(plugin.local.compose)
}

dependencies {
    implementation(projects.modules.kotlin.navigationComposeDestination)
    implementation(projects.modules.kotlin.cicerone)
    implementation(projects.modules.kotlin.ciceroneNavigationCompose)

    implementation(projects.modules.app.ui.common.navigation)

    implementation(projects.modules.app.ui.screens.onboarding)
    implementation(projects.modules.app.ui.screens.main)
    implementation(projects.modules.app.ui.screens.fact)
    implementation(projects.modules.app.ui.screens.factList)

    implementation(libs.compose.navigation)
}