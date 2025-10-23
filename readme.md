### About this project

Localization is one of the most important aspects of the user experience when building software that supports
inclusivity by allowing users to use your software in their preferred language. Compose Multiplatform supports
localization out of the box, but changing the locale in real time is a bit trickier and requires writing a lot of
boilerplate code, which is also challenging to understand. `Localina` Is a Kotlin Multiplatform library that allows you
to update the locale of your Compose Multiplatform app in real time.

### Live preview

View a live preview of `Localina` in action: [Localina Live Preview](https://sudarshanmhasrup.github.io/localina/demo)

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

### Usage guide

It's super easy to use `Localina` for updating your app's locale in real-time. Follow these three steps and you're good
to go.

#### Step 1: Add String Resources

Store all your string resources under `commonMain/composeResource` directory and add localized strings for each
supported language, like this:

```
commonMain/composeResources/
├── values/
│   └── strings.xml
├── values-hi/
│   └── strings.xml
├── values-fr/
│   └── strings.xml
└── ... (other locale directories)
```

#### Step 2: Wrap Your UI with LocalinaApp Composable

Wrap all your UI code inside the
[Localina](/library/src/commonMain/kotlin/io/github/sudarshanmhasrup/localina/api/LocalinaApp.kt) composable, like this:

```kotlin
@Composable
fun App() {
    LocalinaApp {
        // Your UI code here
    }
}
```

#### Step 3: Update the Locale

To change the language at runtime, call the
[updateLocale()](/library/src/commonMain/kotlin/io/github/sudarshanmhasrup/localina/api/LocalinaApp.kt) function with
your desired locale code.

```kotlin
// Replace "hi" with your desired locale code.
LocaleUpdater.updateLocale(locale = "hi")

// Or change language using Locale enum
LocaleUpdater.updateLocale(locale = Locale.Hindi)
```


#### Step 4: (Only for Web) Override Navigator.languages Property

In your browser's index.html, put the following code before loading the application scripts:

```html
<html lang="en">
    <head>
        <meta charset="UTF-8">
        ...
        <script>
            var currentLanguagesImplementation = Object.getOwnPropertyDescriptor(Navigator.prototype, "languages");
            var newLanguagesImplementation = Object.assign({}, currentLanguagesImplementation, {
                get: function () {
                    if (window.__customLocale) {
                        return [window.__customLocale];
                    } else {
                        return currentLanguagesImplementation.get.apply(this);
                    }
                }
            });

            Object.defineProperty(Navigator.prototype, "languages", newLanguagesImplementation)
        </script>
        <script src="skiko.js"></script>
        ...
    </head>
    <body></body>
    <script src="composeApp.js"></script>
</html>
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

### Thank you! 🙌

Thank you so much for checking out the `Localina` project. If you like my work or this project, feel free to give a star
to the repository. Happy coding!
