val plugin = Plugins()

class Plugins internal constructor() {
    val local = Local()
    val android = Android()
    val kotlin = Kotlin()
    val google = Google()

    inner class Local {
        val jvm = "project_jvm"
        val platform = "project_platform"
        val compose = "project_compose"
        val ksp = "project_ksp"
        val koin = "project_koin"
        val coroutines = "project_coroutines"
        val datastore = "project_datastore"
        val ktor = "project_ktor"
    }

    inner class Android {
        val application = "com.android.application"
        val library = "com.android.library"
    }

    inner class Kotlin {
        val jvm = "org.jetbrains.kotlin.jvm"
        val android = "org.jetbrains.kotlin.android"
        val compose = "org.jetbrains.kotlin.plugin.compose"
        val serialization = "org.jetbrains.kotlin.plugin.serialization"
    }

    inner class Google {
        val ksp = "com.google.devtools.ksp"
    }
}