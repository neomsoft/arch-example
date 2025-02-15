plugins {
    id(plugin.local.platform)
    id(plugin.local.koin)
    id(plugin.local.datastore)
}

dependencies {
    implementation(projects.modules.kotlin.storageValue)
    implementation(projects.modules.kotlin.storageValueDatastoreDelegate)
    implementation(projects.modules.app.core.entities)
}