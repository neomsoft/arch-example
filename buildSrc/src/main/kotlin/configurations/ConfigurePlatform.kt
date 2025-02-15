package configurations

import constants.BuildConstants
import extensions.configureAndroid
import extensions.extensionContainer
import extensions.kotlinJvmCompilerOptions
import org.gradle.api.Project

private fun Project.modulePackage(): String {
    val modulesDir = rootDir.path + "/modules"

    val modulePackageSuffix = projectDir.path
        .removePrefix(modulesDir)
        .replace(oldChar = '/', newChar = '.')
        .replace(oldChar = '-', newChar = '.')

    return BuildConstants.APPLICATION_ID + modulePackageSuffix
}

fun Project.configurePlatform(
    modulePackage: String = modulePackage(),
) {
    kotlinJvmCompilerOptions {
        jvmTarget.set(BuildConstants.JVM_VERSION)
    }

    extensionContainer.configureAndroid {
        namespace = modulePackage
        compileSdk = BuildConstants.ANDROID_COMPILE_SDK

        defaultConfig {
            minSdk = BuildConstants.ANDROID_MIN_SDK
        }

        compileOptions {
            sourceCompatibility = BuildConstants.JAVA_VERSION
            targetCompatibility = BuildConstants.JAVA_VERSION
        }
    }
}