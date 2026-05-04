import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalDistributionDsl

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

group = libs.versions.example.web.group.get()
version = libs.versions.example.web.version.get()

kotlin {
    @OptIn(ExperimentalDistributionDsl::class)
    js {
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

layout.buildDirectory.set(file("$rootDir/.build/example/web"))