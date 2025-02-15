package configurations

import extensions.ksp
import org.gradle.api.Project
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.dependencies

fun Project.addKspCompiler(compiler: Provider<MinimalExternalModuleDependency>) {
    dependencies {
        ksp(compiler)
    }
}