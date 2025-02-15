package configurations

import extensions.configureKsp
import extensions.extensionContainer
import extensions.implementation
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import toml.libs

internal fun Project.configureKoin() {
    dependencies {
        implementation(libs.koin.core)
        implementation(libs.koin.composeViewmodel)
        implementation(libs.koin.annotations)
    }

    extensionContainer.configureKsp {
        arg("KOIN_USE_COMPOSE_VIEWMODEL", "true")
    }

    addKspCompiler(libs.koin.kspCompiler)
}