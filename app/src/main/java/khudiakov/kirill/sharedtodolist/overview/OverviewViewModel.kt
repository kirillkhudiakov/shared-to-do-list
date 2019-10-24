package khudiakov.kirill.sharedtodolist.overview

import android.util.Log
import androidx.lifecycle.ViewModel
import khudiakov.kirill.sharedtodolist.database.TodoList
import khudiakov.kirill.sharedtodolist.database.TodoListDao
import kotlinx.coroutines.*

class OverviewViewModel(private val todoListDao: TodoListDao)
    : ViewModel() {

    val lists = todoListDao.getAllLists()

    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    fun insertList(name: String) {
        uiScope.launch {
            val list = TodoList(name)
            Log.i("OverviewViewModel", "Create new list with id = ${list.id}")
            insertInDatabase(list)
        }
    }

    private suspend fun insertInDatabase(todoList: TodoList) {
        withContext(Dispatchers.IO) {
            todoListDao.insert(todoList)
        }
    }
}
