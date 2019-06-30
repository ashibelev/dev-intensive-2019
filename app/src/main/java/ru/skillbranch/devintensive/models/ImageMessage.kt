package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.humanizeDiff
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
    val image: String?
) : BaseMessage(id, from, chat, isIncoming, date) {

    override fun formatMessage() = "id: $id ${from?.firstName}" +
            " ${if (isIncoming) "получил" else "отправил"} изображение \"$image\" ${date.humanizeDiff()}"
}