plugins {
    id(plugin.local.platform)
    id(plugin.local.coroutines)
    id(plugin.local.datastore)
}

dependencies {
    implementation(projects.modules.kotlin.storageValue)
}