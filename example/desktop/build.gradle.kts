import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

group = libs.versions.example.desktop.group.get()
version = libs.versions.example.desktop.version.get()

kotlin {
    jvm("desktop") {
        java {
            toolchain {
                languageVersion.set(JavaLanguageVersion.of("21"))
            }
            sourceCompatibility = JavaVersion.VERSION_21
            targetCompatibility = JavaVersion.VERSION_21
        }

        compilerOptions {
            jvmTarget = JvmTarget.JVM_21
        }
    }

    sourceSets {
        val desktopMain by getting
        desktopMain.dependencies {
            implementation(libs.kotlin.coroutines.swing)
            implementation(compose.desktop.currentOs)
            implementation(projects.example.compose)
        }
    }
}

compose {
    desktop {
        application {
            mainClass = libs.versions.example.desktop.mainClass.get()

            nativeDistributions {
                targetFormats = setOf(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
                packageName = libs.versions.example.desktop.distributionPackageName.get()
                packageVersion = libs.versions.example.desktop.distributionPackageVersion.get()
            }
        }
    }
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/example/desktop"))