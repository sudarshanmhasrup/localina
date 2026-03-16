plugins {
    alias(libs.plugins.android.application)
}

group = libs.versions.example.android.group.get()
version = libs.versions.example.android.version.get()

android {
    namespace = libs.versions.example.android.namespace.get()
    compileSdk = libs.versions.example.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = libs.versions.example.android.applicationId.get()
        minSdk = libs.versions.example.android.minSdk.get().toInt()
        targetSdk = libs.versions.example.android.targetSdk.get().toInt()
        versionCode = libs.versions.example.android.versionCode.get().toInt()
        versionName = libs.versions.example.android.versionName.get()
    }
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/example/desktop"))