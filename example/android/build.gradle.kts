import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.compiler)
}

group = libs.versions.example.android.group.get()
version = libs.versions.example.android.version.get()

kotlin {
    target {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }
    }
}

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

    buildTypes {
        release {
            isMinifyEnabled = true
        }
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.bundles.koin.android)
    implementation(libs.activity)
    implementation(projects.example.compose)
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/example/desktop"))