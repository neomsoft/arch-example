plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(gradleApi())

    // com.android.application
    // com.android.library
    // noinspection UseTomlInstead
    implementation("com.android.tools.build:gradle:8.5.2")

    // org.jetbrains.kotlin.android
    // noinspection UseTomlInstead
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.1.10")

    // org.jetbrains.kotlin.plugin.compose
    // noinspection UseTomlInstead
    implementation("org.jetbrains.kotlin:compose-compiler-gradle-plugin:2.1.10")

    // com.google.devtools.ksp
    // noinspection UseTomlInstead
    implementation("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:2.0.20-1.0.25")

    // org.jetbrains.kotlin.plugin.serialization
    // noinspection UseTomlInstead
    implementation("org.jetbrains.kotlin.plugin.serialization:org.jetbrains.kotlin.plugin.serialization.gradle.plugin:2.1.0")
}