package toml

import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.provideDelegate
import kotlin.properties.ReadOnlyProperty
import org.gradle.kotlin.dsl.project

internal val DependencyHandler.projects get() = Projects(this)

class Projects internal constructor(
    private val dependencyHandler: DependencyHandler,
) {

    inner class Kotlin {
        val flowResult by dep(":modules:kotlin:flow-result")
        val coroutineScopeOwner by dep(":modules:kotlin:coroutine-scope-owner")
    }

    inner class App {

        inner class Core {
            val entity by dep(":modules:app:core:entities")
        }

        inner class Data {
            val repositories by dep(":modules:app:data:repositories")
        }

        inner class Ui {

            inner class Common {
                val design by dep(":modules:app:ui:common:design")
                val navigation by dep(":modules:app:ui:common:navigation")
            }

            val common = Common()
        }

        val core = Core()
        val data = Data()
        val ui = Ui()
    }

    inner class Modules {
        val kotlin = Kotlin()
        val app = App()
    }

    val modules = Modules()

    private fun dep(path: String) =
        ReadOnlyProperty<Any, ProjectDependency> { _, _ -> dependencyHandler.project(path) }
}