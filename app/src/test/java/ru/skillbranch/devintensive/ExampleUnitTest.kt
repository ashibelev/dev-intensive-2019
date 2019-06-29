package ru.skillbranch.devintensive

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.utils.Utils

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
}
