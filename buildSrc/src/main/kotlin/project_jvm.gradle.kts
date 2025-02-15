import constants.BuildConstants

plugins {
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = BuildConstants.JAVA_VERSION
    targetCompatibility = BuildConstants.JAVA_VERSION
}