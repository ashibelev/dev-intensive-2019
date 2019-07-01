package ru.skillbranch.devintensive

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.humanizeDiff
import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun createUserTest() {
        println(User.makeUser("John Doe"))
        println(User.makeUser("John Wick"))
    }

    @Test
    fun parseFullNameTest() {
        println(Utils.parseFullName(null))
        println(Utils.parseFullName(""))
        println(Utils.parseFullName(" "))
        println(Utils.parseFullName("John"))
    }

    @Test
    fun createMessage() {
    }

    @Test
    fun toInitialsTest() {
        println(Utils.toInitials("john", "doe"))
        println(Utils.toInitials("John", null))
        println(Utils.toInitials(null, null))
        println(Utils.toInitials(" ", ""))
        println(Utils.toInitials(null, "doe"))
    }

    @Test
    fun transliterationTest() {
        println(Utils.transliteration("Женя Стереотипов "))
        println(Utils.transliteration("Amazing Петр ", "_"))
    }

    @Test
    fun humanizeDate() {
        println(Date().humanizeDiff())

        println(Date().add(15, TimeUnits.SECOND).humanizeDiff())
        println(Date().add(-15, TimeUnits.SECOND).humanizeDiff())

        println(Date().add(55, TimeUnits.SECOND).humanizeDiff())
        println(Date().add(-65, TimeUnits.SECOND).humanizeDiff())

        println(Date().add(2, TimeUnits.MINUTE).humanizeDiff())
        println(Date().add(5, TimeUnits.MINUTE).humanizeDiff())
        println(Date().add(11, TimeUnits.MINUTE).humanizeDiff())
        println(Date().add(-2, TimeUnits.MINUTE).humanizeDiff())
        println(Date().add(-5, TimeUnits.MINUTE).humanizeDiff())
        println(Date().add(-11, TimeUnits.MINUTE).humanizeDiff())

        println(Date().add(60, TimeUnits.MINUTE).humanizeDiff())
        println(Date().add(-60, TimeUnits.MINUTE).humanizeDiff())

        println(Date().add(2, TimeUnits.HOUR).humanizeDiff())
        println(Date().add(5, TimeUnits.HOUR).humanizeDiff())
        println(Date().add(21, TimeUnits.HOUR).humanizeDiff())
        println(Date().add(-2, TimeUnits.HOUR).humanizeDiff())
        println(Date().add(-5, TimeUnits.HOUR).humanizeDiff())
        println(Date().add(-21, TimeUnits.HOUR).humanizeDiff())

        println(Date().add(24, TimeUnits.HOUR).humanizeDiff())
        println(Date().add(-24, TimeUnits.HOUR).humanizeDiff())

        println(Date().add(2, TimeUnits.DAY).humanizeDiff())
        println(Date().add(5, TimeUnits.DAY).humanizeDiff())
        println(Date().add(21, TimeUnits.DAY).humanizeDiff())
        println(Date().add(-2, TimeUnits.DAY).humanizeDiff())
        println(Date().add(-5, TimeUnits.DAY).humanizeDiff())
        println(Date().add(-21, TimeUnits.DAY).humanizeDiff())

        println(Date().add(370, TimeUnits.DAY).humanizeDiff())
        println(Date().add(-370, TimeUnits.DAY).humanizeDiff())

        println(" --- ")
        println(Date().add(-2, TimeUnits.HOUR).humanizeDiff())
        println(Date().add(-5, TimeUnits.DAY).humanizeDiff())
        println(Date().add(2, TimeUnits.MINUTE).humanizeDiff())
        println(Date().add(7, TimeUnits.DAY).humanizeDiff())
        println(Date().add(-400, TimeUnits.DAY).humanizeDiff())
        println(Date().add(400, TimeUnits.DAY).humanizeDiff())
    }

    @Test
    fun userBuilderTest() {
        val user = User.Builder().id("1")
            .firstName("John")
            .lastName("Doe")
            .avatar("")
            .rating(1)
            .respect(1)
            .lastVisit(Date())
            .isOnline(false)
            .build()
        println(user)
    }
}
