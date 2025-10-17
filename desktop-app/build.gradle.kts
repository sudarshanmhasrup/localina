plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.hot.reload)
}

group = libs.versions.desktopApp.group.get()
version = libs.versions.desktopApp.version.get()

kotlin {
    jvm()

    sourceSets {
        jvmMain.dependencies {
            implementation(libs.kotlin.coroutines.swing)
            implementation(compose.desktop.currentOs)
            implementation(projects.composeApp)
        }
    }
}

compose.desktop {
    application {
        mainClass = libs.versions.desktopApp.mainClass.get()
    }
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/DesktopApp"))