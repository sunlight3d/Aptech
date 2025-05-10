package com.fit2081.irene33624658.utils

/**
 * Extension function to validate password requirements:
 * - At least 6 characters
 * - Contains both letters and numbers
 */
fun String.isValidPassword(): Boolean {
    return length >= 6 && any { it.isDigit() } && any { it.isLetter() }
}

/**
 * Extension function to validate phone number format
 */
fun String.isValidPhoneNumber(): Boolean {
    return matches(Regex("^[0-9]{10,15}$"))
}