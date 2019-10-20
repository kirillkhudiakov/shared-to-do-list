package khudiakov.kirill.sharedtodolist.overview

import androidx.lifecycle.ViewModel
import khudiakov.kirill.sharedtodolist.database.TodoListDao

class OverviewViewModel(private val todoListDao: TodoListDao)
    : ViewModel() {

    val lists = todoListDao.getAllLists()
}
