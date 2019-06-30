package ru.skillbranch.devintensive.models

import java.util.*

/**
 * Created on 2019-06-30.
 *
 * @author Alexandr Shibelev (av.shibelev@gmail.com)
 */
class ImageMessage(
    id: String,
    from: User?,
    chat: Chat,
    isIncoming: Boolean = false,
    date: Date = Date(),
    val payload: String? = null
) : BaseMessage(id, from, chat, isIncoming, date) {

    override fun formatMessage(): String {
        return ""
    }
}