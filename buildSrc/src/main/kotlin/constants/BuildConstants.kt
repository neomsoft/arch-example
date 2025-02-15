package constants

import org.gradle.api.JavaVersion
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

object BuildConstants {
    const val APPLICATION_ID = "arch.example"
    const val ANDROID_MIN_SDK = 26
    const val ANDROID_TARGET_SDK = 35
    const val ANDROID_COMPILE_SDK = 35
    const val ANDROID_VERSION_CODE = 1
    const val ANDROID_VERSION_NAME = "1.0"

    val JAVA_VERSION = JavaVersion.VERSION_21
    val JVM_VERSION = JvmTarget.JVM_21
}