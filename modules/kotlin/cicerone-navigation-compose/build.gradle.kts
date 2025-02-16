plugins {
    id(plugin.local.platform)
    id(plugin.local.compose)
}

dependencies {
    implementation(projects.modules.kotlin.disposableEffectWithLifecycle)
    implementation(projects.modules.kotlin.cicerone)
    implementation(libs.compose.navigation)
}
