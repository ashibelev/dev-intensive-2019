package ru.skillbranch.devintensive.models

/**
 * Created on 2019-06-29.
 *
 * @author Alexandr Shibelev (av.shibelev@gmail.com)
 */
class Chat(
    val id: String,
    val members: MutableList<User> = mutableListOf(),
    val messages: MutableList<BaseMessage> = mutableListOf()
) {
}