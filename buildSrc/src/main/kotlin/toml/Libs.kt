package toml

import org.gradle.api.Project
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.getByType

private val Project.versionCatalog: VersionCatalog
    get() = project.extensions.getByType<VersionCatalogsExtension>().named("libs")

internal val Project.libs: Libs
    get() = Libs(versionCatalog)

internal class Libs(
    private val versionCatalog: VersionCatalog,
) {
    val androidx = AndroidX()

    inner class AndroidX {
        val compose = Compose()

        inner class Compose {
            val bom = library(alias = "androidx.compose.bom")
            val ui = library(alias = "androidx.ui")
            val graphics = library(alias = "androidx.ui.graphics")
            val tooling = library(alias = "androidx.ui.tooling")
            val toolingPreview = library(alias = "androidx.ui.tooling.preview")
            val testManifest = library(alias = "androidx.ui.test.manifest")
            val testJunit4 = library(alias = "androidx.ui.test.junit4")
            val material3 = library(alias = "androidx.material3")
        }
    }

    private fun library(alias: String): Provider<MinimalExternalModuleDependency> {
        return versionCatalog.findLibrary(alias).get()
    }
}