plugins {
    id(plugin.local.jvm)
    id(plugin.local.coroutines)
}

dependencies {
    implementation(projects.modules.kotlin.flowResult)
    implementation(projects.modules.app.core.entities)
}