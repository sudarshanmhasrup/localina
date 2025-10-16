import com.android.build.api.dsl.androidLibrary
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

group = libs.versions.composeApp.group.get()
version = libs.versions.composeApp.version.get()

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

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
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
    packageOfResClass = libs.versions.composeApp.packageOfResClass.get()
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/ComposeApp"))