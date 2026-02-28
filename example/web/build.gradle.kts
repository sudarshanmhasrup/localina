import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalDistributionDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    @OptIn(ExperimentalDistributionDsl::class)
    js(IR) {
        browser {
            distribution {
                outputDirectory = File("$rootDir/.build/WebAppDistribution")
            }
        }
        binaries.executable()
    }

    @OptIn(ExperimentalWasmDsl::class, ExperimentalDistributionDsl::class)
    wasmJs {
        browser {
            distribution {
                outputDirectory = File("$rootDir/.build/WebAppDistribution")
            }
        }
        binaries.executable()
    }

    sourceSets {
        webMain.dependencies {
            implementation(libs.compose.multiplatform.ui)
            implementation(projects.example.compose)
        }
    }
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/example/web"))