import com.android.build.api.dsl.androidLibrary
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.maven.publish)
}

group = libs.versions.library.group.get()
version = libs.versions.library.version.get()

kotlin {
    @Suppress("UnstableApiUsage")
    androidLibrary {
        namespace = libs.versions.library.androidLibrary.namespace.get()
        compileSdk = libs.versions.library.androidLibrary.compileSdk.get().toInt()
        minSdk = libs.versions.library.androidLibrary.minSdk.get().toInt()

        compilations.configureEach {
            compilerOptions.configure {
                jvmTarget.set(
                    JvmTarget.JVM_11
                )
            }
        }
    }

    jvm()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.multiplatform.ui)
        }
    }
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/Library"))