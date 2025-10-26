import com.android.build.api.dsl.androidLibrary
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.maven.publish)
}

group = libs.versions.library.group.get()
version = libs.versions.library.version.get()

kotlin {
    @Suppress("UnstableApiUsage")
    androidLibrary {
        namespace = libs.versions.library.androidLibrary.namespace.get()
        compileSdk = libs.versions.library.androidLibrary.compileSdk.get().toInt()
        minSdk = libs.versions.library.androidLibrary.minSdk.get().toInt()

        compilations.configureEach {
            compilerOptions.configure {
                jvmTarget.set(
                    JvmTarget.JVM_11
                )
            }
        }
    }

    jvm()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

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
            implementation(libs.compose.multiplatform.runtime)
            implementation(libs.compose.multiplatform.ui)
        }
    }
}

mavenPublishing {
    publishToMavenCentral()
    signAllPublications()

    coordinates(
        groupId = libs.versions.library.group.get(),
        artifactId = libs.versions.library.artifactId.get(),
        version = libs.versions.library.version.get()
    )

    pom {
        name.set("Localina")
        description.set("A Kotlin Multiplatform library that supports real-time locale updates in your Compose Multiplatform app.")
        inceptionYear.set("2025")
        url.set("https://github.com/sudarshanmhasrup/localina")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("repo")
            }
        }
        developers {
            developer {
                id.set("sudarshanmhasrup")
                name.set("Sudarshan")
                url.set("https://github.com/sudarshanmhasrup")
            }
        }
        scm {
            url.set("https://github.com/sudarshanmhasrup/localina")
            connection.set("scm:git:https://github.com/sudarshanmhasrup/localina.git")
            developerConnection.set("scm:git:ssh://git@github.com/sudarshanmhasrup/localina.git")
        }
    }
}