package ru.skillbranch.devintensive.utils

/**
 * Created on 2019-06-29.
 *
 * @author Alexandr Shibelev (av.shibelev@gmail.com)
 */
object Utils {

    private val transliterationMap = mapOf(
        'а' to "a",
        'б' to "b",
        'в' to "v",
        'г' to "g",
        'д' to "d",
        'е' to "e",
        'ё' to "e",
        'ж' to "zh",
        'з' to "z",
        'и' to "i",
        'й' to "i",
        'к' to "k",
        'л' to "l",
        'м' to "m",
        'н' to "n",
        'о' to "o",
        'п' to "p",
        'р' to "r",
        'с' to "s",
        'т' to "t",
        'у' to "u",
        'ф' to "f",
        'х' to "h",
        'ц' to "c",
        'ч' to "ch",
        'ш' to "sh",
        'щ' to "sh",
        'ъ' to "",
        'ы' to "i",
        'ь' to "",
        'э' to "e",
        'ю' to "yu",
        'я' to "ya"
    )

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
        val stringBuilder = StringBuilder()
        payload.trim().forEach {
            when {
                it.isWhitespace() -> stringBuilder.append(divider)
                it.isUpperCase() -> {
                    val translate = transliterationMap[it.toLowerCase()]
                    if (translate == null) {
                        stringBuilder.append(it)
                    } else {
                        if (translate.length > 1) {
                            stringBuilder.append(translate.substring(0, 1).toUpperCase())
                                .append(translate.substring(1))
                        } else {
                            stringBuilder.append(translate.toUpperCase())
                        }
                    }
                }
                else -> {
                    val translate = transliterationMap[it]
                    if (translate == null) {
                        stringBuilder.append(it)
                    } else {
                        stringBuilder.append(translate)
                    }
                }
            }
        }
        return stringBuilder.toString()
    }
}