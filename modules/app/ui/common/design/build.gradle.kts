plugins {
    id(plugin.local.platform)
    id(plugin.local.compose)
}

dependencies {
    implementation(projects.modules.kotlin.flowResult)
    implementation(projects.modules.app.core.entities)
}