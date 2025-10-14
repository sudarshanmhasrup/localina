plugins {
    alias(libs.plugins.kotlin.multiplatform)
}

group = libs.versions.library.group.get()
version = libs.versions.library.version.get()

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/Library"))