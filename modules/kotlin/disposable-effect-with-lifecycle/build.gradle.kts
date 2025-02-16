plugins {
    id(plugin.local.platform)
    id(plugin.local.compose)
}

dependencies {
    implementation(libs.androidx.lifecycle.runtime.compose)
}
