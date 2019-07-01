package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

/**
 * Created on 2019-06-29.
 *
 * @author Alexandr Shibelev (av.shibelev@gmail.com)
 */
data class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    var lastVisit: Date? = Date(),
    var isOnline: Boolean = false
) {

    constructor(id: String, firstName: String?, lastName: String?) : this(id, firstName, lastName, null)

    private constructor(builder: Builder) : this(
        builder.id, builder.firstName, builder.lastName, builder.avatar,
        builder.rating, builder.respect, builder.lastVisit, builder.isOnline
    )

    companion object Factory {

        private var lastId: Int = -1

        fun makeUser(fullName: String): User {
            val (firstName, lastName) = Utils.parseFullName(fullName)
            return User("${++lastId}", firstName, lastName)
        }
    }

    class Builder {
        var id: String = ""
            private set
        var firstName: String = ""
            private set
        var lastName: String = ""
            private set
        var avatar: String = ""
            private set
        var rating: Int = 0
            private set
        var respect: Int = 0
            private set
        var lastVisit: Date? = Date()
            private set
        var isOnline: Boolean = false
            private set

        fun id(id: String): Builder = apply { this.id = id }
        fun firstName(firstName: String): Builder = apply { this.firstName = firstName }
        fun lastName(lastName: String): Builder = apply { this.lastName = lastName }
        fun avatar(avatar: String): Builder = apply { this.avatar = avatar }
        fun rating(rating: Int): Builder = apply { this.rating = rating }
        fun respect(respect: Int): Builder = apply { this.respect = respect }
        fun lastVisit(lastVisit: Date): Builder = apply { this.lastVisit = lastVisit }
        fun isOnline(isOnline: Boolean): Builder = apply { this.isOnline = isOnline }

        fun build(): User = User(this)
    }
}