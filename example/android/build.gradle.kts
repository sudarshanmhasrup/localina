plugins {
    alias(libs.plugins.kotlin.android)
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/example/desktop"))