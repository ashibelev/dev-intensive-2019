package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.humanizeDiff
import java.util.*

/**
 * Created on 2019-06-29.
 *
 * @author Alexandr Shibelev (av.shibelev@gmail.com)
 */
class TextMessage(
    id: String,
    from: User?,
    chat: Chat,
    isIncoming: Boolean = false,
    date: Date = Date(),
    val text: String?
) : BaseMessage(id, from, chat, isIncoming, date) {

    override fun formatMessage() = "id: $id ${from?.firstName}" +
            " ${if (isIncoming) "получил" else "отправил"} сообщение \"$text\" ${date.humanizeDiff()}"
}