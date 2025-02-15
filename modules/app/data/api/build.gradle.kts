plugins {
    id(plugin.local.platform)
    id(plugin.local.koin)
    id(plugin.local.coroutines)
    id(plugin.local.ktor)
}

dependencies {
    implementation(projects.modules.kotlin.httpclientResultExtensions)
}