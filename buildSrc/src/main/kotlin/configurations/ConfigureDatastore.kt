package configurations

import extensions.implementation
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import toml.libs

internal fun Project.configureDatastore() {
    dependencies {
        implementation(libs.datastore.core)
        implementation(libs.datastore.preferences)
    }
}