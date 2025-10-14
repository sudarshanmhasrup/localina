plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/Library"))