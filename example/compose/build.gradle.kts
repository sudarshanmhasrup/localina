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
    android {
        namespace = libs.versions.example.compose.androidLibrary.namespace.get()
        compileSdk = libs.versions.example.compose.androidLibrary.compileSdk.get().toInt()
        minSdk = libs.versions.example.compose.androidLibrary.minSdk.get().toInt()

        androidResources.enable = true

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
        commonMain.dependencies {
            implementation(libs.bundles.koin.multiplatform)
            implementation(libs.bundles.compose.multiplatform.lifecyle)
            implementation(libs.bundles.compose.multiplatform)
            implementation(projects.library)
        }
    }
}

dependencies {
    androidRuntimeClasspath(libs.compose.multiplatform.ui.tooling)
}

compose.resources {
    customDirectory(
        sourceSetName = "commonMain",
        directoryProvider = provider { layout.projectDirectory.dir("src/commonMain/resources") }
    )
    packageOfResClass = libs.versions.example.compose.packageOfResClass.get()
}