import configurations.configurePlatform
import constants.BuildConstants

plugins {
    id(plugin.android.application)
    id(plugin.kotlin.android)
    id(plugin.local.compose)
    id(plugin.local.koin)
}

configurePlatform(modulePackage = BuildConstants.APPLICATION_ID)

android {
    defaultConfig {
        applicationId = BuildConstants.APPLICATION_ID
        targetSdk = BuildConstants.ANDROID_TARGET_SDK
        versionCode = BuildConstants.ANDROID_VERSION_CODE
        versionName = BuildConstants.ANDROID_VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(projects.modules.kotlin.storageValue)
    implementation(projects.modules.kotlin.flowResult)
    implementation(projects.modules.kotlin.coroutineScopeOwner)

    implementation(projects.modules.app.core.entities)
    implementation(projects.modules.app.data.preferences)
    implementation(projects.modules.app.data.api)
    implementation(projects.modules.app.data.database)
    implementation(projects.modules.app.data.repositories)
    implementation(projects.modules.app.data.repositoriesImpl)

    implementation(projects.modules.app.ui.common.design)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.koin.android)
    implementation(libs.androidx.splashscreen)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}