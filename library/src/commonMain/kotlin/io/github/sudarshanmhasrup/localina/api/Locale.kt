package io.github.sudarshanmhasrup.localina.api

import io.github.sudarshanmhasrup.localina.annoations.ExperimentalLocalinaApi

/**
 * An enum class that defines supported languages in the application with their corresponding ISO 639-1 language codes.
 * Each enum constant represents a language and is associated with its two-letter language code.
 *
 * @property code The two-letter ISO 639-1 language code for the locale
 */
@ExperimentalLocalinaApi
public enum class Locale(val code: String) {
    English(code = "en"),
    Marathi(code = "mr"),
    Hindi(code = "hi")
}