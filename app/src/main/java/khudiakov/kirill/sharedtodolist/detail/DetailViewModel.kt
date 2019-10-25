package khudiakov.kirill.sharedtodolist.detail

import androidx.lifecycle.ViewModel
import khudiakov.kirill.sharedtodolist.database.TodoDao

class DetailViewModel(private val listId: Long, private val todoDao: TodoDao) : ViewModel() {

    val todos = todoDao.getTodosFromList(listId)
}
