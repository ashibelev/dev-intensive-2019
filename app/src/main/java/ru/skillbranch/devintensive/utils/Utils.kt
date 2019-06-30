package ru.skillbranch.devintensive.utils

/**
 * Created on 2019-06-29.
 *
 * @author Alexandr Shibelev (av.shibelev@gmail.com)
 */
object Utils {

    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts = fullName?.run {
            if (isNullOrBlank()) {
                null
            } else {
                split(" ")
            }
        }
        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        return firstName to lastName
    }

    fun toInitials(fullName: String?, lastName: String? = null): String? {
        val firstLetter = fullName?.takeIf { it.isNotBlank() }?.substring(0, 1)?.toUpperCase() ?: ""
        val lastLetter = lastName?.takeIf { it.isNotBlank() }?.substring(0, 1)?.toUpperCase() ?: ""
        return "$firstLetter$lastLetter".takeIf { it.isNotBlank() }
    }

    fun transliteration(payload: String, divider: String = " "): String {
        return ""
    }
}