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
    }

    inner class Android {
        val application = "com.android.application"
        val library = "com.android.library"
    }

    inner class Kotlin {
        val jvm = "org.jetbrains.kotlin.jvm"
        val android = "org.jetbrains.kotlin.android"
        val compose = "org.jetbrains.kotlin.plugin.compose"
    }

    inner class Google {
        val ksp = "com.google.devtools.ksp"
    }
}