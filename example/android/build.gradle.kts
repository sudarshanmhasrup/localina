plugins {
    alias(libs.plugins.android.application)
}

group = libs.versions.example.android.group.get()
version = libs.versions.example.android.version.get()

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/example/desktop"))