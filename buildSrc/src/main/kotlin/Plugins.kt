val plugin = Plugins()

class Plugins internal constructor() {
    val local = Local()
    val android = Android()
    val kotlin = Kotlin()

    inner class Local {
        val jvm = "project_jvm"
        val platform = "project_platform"
        val compose = "project_compose"
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
}