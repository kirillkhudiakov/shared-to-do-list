package khudiakov.kirill.sharedtodolist.overview

import androidx.lifecycle.ViewModel
import khudiakov.kirill.sharedtodolist.database.TodoDao
import khudiakov.kirill.sharedtodolist.database.TodoListDao

class OverviewViewModel(private val todoDao: TodoDao, private val todoListDao: TodoListDao)
    : ViewModel() {

}
