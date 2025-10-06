import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

group = libs.versions.webApp.group.get()
version = libs.versions.webApp.version.get()

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }

    sourceSets {
        wasmJsMain.dependencies {
            implementation(libs.compose.multiplatform.ui)
            implementation(projects.composeApp)
        }
    }
}

// Custom build directory
layout.buildDirectory.set(file(path = "$rootDir/.build/WebApp"))