import configurations.configurePlatform
import constants.BuildConstants

plugins {
    id(plugin.android.application)
    id(plugin.kotlin.android)
    id(plugin.local.compose)
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
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}