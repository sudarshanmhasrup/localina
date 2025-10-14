plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.android.library) apply false
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/RootProject"))