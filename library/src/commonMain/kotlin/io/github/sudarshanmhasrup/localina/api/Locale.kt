package io.github.sudarshanmhasrup.localina.api

/**
 * An enum class that defines supported languages in the application with their corresponding ISO 639-1 language codes.
 * Each enum constant represents a language and is associated with its two-letter language code.
 *
 * @property code The two-letter ISO 639-1 language code for the locale
 */
enum class Locale(val code: String) {
    English(code = "en"),
    Marathi(code = "mr"),
    Hindi(code = "hi")
}