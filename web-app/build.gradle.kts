import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalDistributionDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

group = libs.versions.webApp.group.get()
version = libs.versions.webApp.version.get()

kotlin {
    @OptIn(
        ExperimentalWasmDsl::class,
        ExperimentalDistributionDsl::class
    )
    wasmJs {
        browser {
            distribution {
                outputDirectory = File("$rootDir/.build/WebAppDistribution")
            }
        }
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