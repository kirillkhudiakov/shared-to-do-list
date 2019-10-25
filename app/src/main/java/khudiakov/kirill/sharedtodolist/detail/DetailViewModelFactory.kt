package khudiakov.kirill.sharedtodolist.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import khudiakov.kirill.sharedtodolist.database.TodoDao

class DetailViewModelFactory(private val listId: Long, private val todoDao: TodoDao)
    : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(listId, todoDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}