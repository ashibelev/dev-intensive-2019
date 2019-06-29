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
}