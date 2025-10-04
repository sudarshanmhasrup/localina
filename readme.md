### About this project

Localization is one of the most important aspects of the user experience when building software that supports
inclusivity by allowing users to use your software in their preferred language. Compose Multiplatform supports 
localization out of the box, but changing the locale in real time is a bit trickier and requires writing a lot of 
boilerplate code, which is also challenging to understand. `Localina` is a Compose Multiplatform library that enables 
real-time localization of your Compose Multiplatform-powered app with an easy-to-use API.

### Supported platforms

Localina supports all platforms that Compose Multiplatform supports. This includes:

| Platform | Target(s)                                       |
|----------|-------------------------------------------------|
| Android  | `androidTarget()`                               |
| iOS      | `iosX64()`, `iosArm64()`, `iosSimulatorArm64()` |
| Desktop  | `jvm()`                                         |
| Web      | `wasmJs0()`                                     |