plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/RootProject"))