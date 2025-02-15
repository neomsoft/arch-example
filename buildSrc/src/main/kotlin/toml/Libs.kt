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
    val kotlinx = Kotlinx()
    val koin = Koin()
    val datastore = Datastore()
    val ktor = Ktor()
    val room = Room()
    val sqlite = Sqlite()

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

    inner class Koin {
        val core = library(alias = "koin.core")
        val android = library(alias = "koin.android")
        val composeViewmodel = library(alias = "koin.composeViewmodel")
        val annotations = library(alias = "koin.annotations")
        val kspCompiler = library(alias = "koin.ksp.compiler")
    }

    inner class Kotlinx {
        val coroutines = library(alias = "kotlinx.coroutines.core")
    }

    inner class Datastore {
        val core = library(alias = "datastore.core")
        val preferences = library(alias = "datastore.preferences")
    }

    inner class Ktor {
        val client = Client()
        val serialization = Serialization()

        inner class Client {
            val android = library(alias = "ktor.client.android")
            val core = library(alias = "ktor.client.core")
            val contentNegotiation = library(alias = "ktor.client.contentNegotiation")
        }

        inner class Serialization {
            val kotlinx = library(alias = "ktor.serialization.kotlinx")
        }
    }

    inner class Room {
        val runtime = library(alias = "room.runtime")
        val android = library(alias = "room.android")
        val compiler = library(alias = "room.compiler")
    }

    inner class Sqlite {
        val bundled = library(alias = "sqlite.bundled")
    }

    private fun library(alias: String): Provider<MinimalExternalModuleDependency> {
        return versionCatalog.findLibrary(alias).get()
    }
}