package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.absoluteValue

/**
 * Created on 2019-06-30.
 *
 * @author Alexandr Shibelev (av.shibelev@gmail.com)
 */

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time

    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }

    this.time = time
    return this
}

val PLURAL_MINUTE = mapOf(
    0 to "минута",
    1 to "минуты",
    2 to "минут",
    3 to "минут"
)

val PLURAL_HOUR = mapOf(
    0 to "час",
    1 to "часа",
    2 to "часов",
    3 to "часов"
)

val PLURAL_DAY = mapOf(
    0 to "день",
    1 to "дня",
    2 to "дней",
    3 to "дней"
)

fun Date.humanizeDiff(date: Date = Date()): String {
    val diff = (date.time - time)
    val value = diff.absoluteValue

    val text = when {
        value <= 1 * SECOND -> return "только что"
        value <= 45 * SECOND -> "несколько секунд"
        value <= 75 * SECOND -> "минуту"
        value <= 45 * MINUTE -> {
            val minutes = value / MINUTE
            "$minutes ${PLURAL_MINUTE[minutes.pluralize()]}"
        }
        value <= 75 * MINUTE -> "час"
        value <= 22 * HOUR -> {
            val hours = value / HOUR
            "$hours ${PLURAL_HOUR[hours.pluralize()]}"
        }
        value <= 26 * HOUR -> "день"
        value <= 360 * DAY -> {
            val days = value / DAY
            "$days ${PLURAL_DAY[days.pluralize()]}"
        }
        else -> return if (diff > 0) "более года назад" else "более чем через год"
    }

    return if (diff < 0) {
        "через $text"
    } else {
        "$text назад"
    }
}

// 20 - часов
// 1 - час
// 2-4 - часа
// 5..часов
fun Long.pluralize(): Int {
    return if (this in 5..20) {
        3
    } else when (this % 10) {
        0L -> 2
        1L -> 0
        in 2..5 -> 1
        in 5..9 -> 2
        else -> 3
    }
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}

