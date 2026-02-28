import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

group = libs.versions.example.compose.group.get()
version = libs.versions.example.compose.version.get()

kotlin {
    androidLibrary {
        namespace = libs.versions.example.compose.androidLibrary.namespace.get()
        compileSdk = libs.versions.example.compose.androidLibrary.compileSdk.get().toInt()
        minSdk = libs.versions.example.compose.androidLibrary.minSdk.get().toInt()

        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }
    }

    jvm("desktop") {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_21
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
        }
    }

    js(IR) {
        browser()
        binaries.executable()
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.compose.multiplatform.ui.tooling.preview)
        }
        commonMain.dependencies {
            implementation(libs.bundles.koin.multiplatform)
            implementation(libs.lifecycle.runtime.compose)
            implementation(libs.compose.multiplatform.viewmodel)
            implementation(libs.material3.adaptive)
            implementation(libs.compose.multiplatform.material3)
            implementation(libs.compose.multiplatform.ui)
            implementation(libs.compose.multiplatform.foundation)
            implementation(libs.compose.multiplatform.resources)
            implementation(libs.compose.multiplatform.components.ui.tooling.preview)
            implementation(projects.library)
        }
    }
}

compose.resources {
    packageOfResClass = libs.versions.example.compose.packageOfResClass.get()
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/example/compose"))