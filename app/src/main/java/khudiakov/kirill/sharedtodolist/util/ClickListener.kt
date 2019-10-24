package khudiakov.kirill.sharedtodolist.util

import khudiakov.kirill.sharedtodolist.database.TodoList

class ClickListener(val listener: (id: Long) -> Unit) {
    fun onClick(list: TodoList) = listener(list.id)
}