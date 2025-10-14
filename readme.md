### About this project

Localization is one of the most important aspects of the user experience when building software that supports
inclusivity by allowing users to use your software in their preferred language. Compose Multiplatform supports
localization out of the box, but changing the locale in real time is a bit trickier and requires writing a lot of
boilerplate code, which is also challenging to understand. `Localina` Is a Kotlin Multiplatform library that allows you
to update the locale of your Compose Multiplatform app in real time.

### Installation guide

To get started, add the `Localina` dependency to your existing [Gradle](https://gradle.org/) project. To make `Localina`
available in any module's classpath, copy and paste the following line into your module's `build.gradle.kts` file under
the `dependencies` block as shown below.

```kotlin
kotlin {
    sourceSets {
        commonMain.dependencies {
            // Other dependencies will go here
            implementation("io.github.sudarshanmhasrup.localina:localina:1.0.0-alpha")
        }
    }
}
```

To quickly copy the dependency, you can use the following command:

```kotlin
implementation("io.github.sudarshanmhasrup.localina:localina:1.0.0-alpha")
```

If your project uses a version catalog for centralized dependency management, add the following
lines to your `libs.versions.toml` file:

```
[versions]
# Other version declarations will go here
localina = "1.0.0-alpha"

[libraries]
# Other libraries declarations will go here
localina = { module = "io.github.sudarshanmhasrup.localina:localina", version.ref = "localina" }
```

Then you can refer to the dependency in your `build.gradle.kts` like this:

```kotlin
kotlin {
    sourceSets {
        commonMain.dependencies {
            // Other dependencies will go here
            implementation(libs.localina)
        }
    }
}
```

To quickly copy the dependency, you can use the following command:

```kotlin
implementation(libs.localina)
```

### Supported platforms

`Localina` supports all platforms that Compose Multiplatform supports. This includes:

| Platform | Target(s)                                       |
|----------|-------------------------------------------------|
| Android  | `androidTarget()`                               |
| iOS      | `iosX64()`, `iosArm64()`, `iosSimulatorArm64()` |
| Desktop  | `jvm()`                                         |
| Web      | `wasmJs()`                                      |

### Contributing

Contributions are welcome! Please feel free to open an issue or submit a pull request.

### Thank you 🙌

Thank you so much for checking out the `Localina` project. If you like my work or this project, feel
free to give a star to the repository. Happy coding!