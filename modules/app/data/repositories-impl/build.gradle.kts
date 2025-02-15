plugins {
    id(plugin.local.platform)
    id(plugin.local.coroutines)
    id(plugin.local.koin)
}

dependencies {
    implementation(projects.modules.kotlin.storageValue)
    implementation(projects.modules.kotlin.flowResult)
    implementation(projects.modules.app.core.entities)
    implementation(projects.modules.app.data.preferences)
    implementation(projects.modules.app.data.repositories)
}