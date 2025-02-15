package configurations

import extensions.androidTestImplementation
import extensions.configureAndroid
import extensions.debugImplementation
import extensions.extensionContainer
import extensions.implementation
import toml.libs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureCompose() {
    extensionContainer.configureAndroid {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = "1.5.1"
        }

        dependencies {
            implementation(platform(libs.androidx.compose.bom))
            implementation(libs.androidx.compose.ui)
            implementation(libs.androidx.compose.graphics)
            implementation(libs.androidx.compose.toolingPreview)
            implementation(libs.androidx.compose.material3)

            androidTestImplementation(platform(libs.androidx.compose.bom))
            androidTestImplementation(libs.androidx.compose.testJunit4)

            debugImplementation(libs.androidx.compose.tooling)
            debugImplementation(libs.androidx.compose.testManifest)
        }
    }
}