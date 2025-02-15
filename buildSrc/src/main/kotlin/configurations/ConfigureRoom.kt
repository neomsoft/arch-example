package configurations
import extensions.configureRoom
import extensions.extensionContainer
import extensions.implementation
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import toml.libs

internal fun Project.configureRoom() {
    dependencies {
        implementation(libs.room.runtime)
        implementation(libs.room.android)
        implementation(libs.sqlite.bundled)
    }

    addKspCompiler(libs.room.compiler)

    extensionContainer.configureRoom {
        schemaDirectory("$projectDir/schemas")
    }
}