plugins {
    alias(libs.plugins.android.application)
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/example/desktop"))