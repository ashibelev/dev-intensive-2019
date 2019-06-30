package ru.skillbranch.devintensive.models

import android.support.annotation.StringDef
import java.util.*

/**
 * Created on 2019-06-29.
 *
 * @author Alexandr Shibelev (av.shibelev@gmail.com)
 */
abstract class BaseMessage(
    val id: String,
    val from: User?,
    val chat: Chat,
    val isIncoming: Boolean = false,
    val date: Date = Date()
) {

    abstract fun formatMessage(): String

    @StringDef(TYPE_TEXT, TYPE_IMAGE)
    @Retention(AnnotationRetention.SOURCE)
    annotation class Type

    companion object AbstractFactory {

        private var lastMessageId: Int = -1

        const val TYPE_TEXT = "text"
        const val TYPE_IMAGE = "image"

        fun makeMessage(
            from: User?,
            chat: Chat,
            date: Date,
            @Type type: String,
            payload: String?,
            isIncoming: Boolean = false
        ): BaseMessage = when (type) {
            TYPE_TEXT -> TextMessage("${++lastMessageId}", from, chat, isIncoming, date, payload)
            TYPE_IMAGE -> ImageMessage("${++lastMessageId}", from, chat, isIncoming, date, payload)
            else -> throw IllegalArgumentException("Unknown message type: $type")
        }
    }
}