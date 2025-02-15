package configurations

import extensions.implementation
import toml.libs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureKtor() {
    dependencies {
        implementation(libs.ktor.client.android)
        implementation(libs.ktor.client.core)
        implementation(libs.ktor.client.contentNegotiation)
        implementation(libs.ktor.serialization.kotlinx)
    }
}