package khudiakov.kirill.sharedtodolist.overview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import khudiakov.kirill.sharedtodolist.database.TodoDao
import khudiakov.kirill.sharedtodolist.database.TodoListDao
import java.lang.IllegalArgumentException

class OverviewViewModelFactory(private val todoDao: TodoDao, private val todoListDao: TodoListDao)
    : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OverviewViewModel::class.java)) {
            return OverviewViewModel(todoDao, todoListDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}