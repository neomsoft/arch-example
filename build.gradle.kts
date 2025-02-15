// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // This is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    id(plugin.kotlin.jvm) apply false
    id(plugin.android.application) apply false
    id(plugin.android.library) apply false
    id(plugin.kotlin.android) apply false
    id(plugin.kotlin.compose) apply false
    id(plugin.google.ksp) apply false
}