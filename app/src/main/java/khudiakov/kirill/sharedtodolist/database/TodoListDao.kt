package khudiakov.kirill.sharedtodolist.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoListDao {

    @Insert
    fun insert(todoList: TodoList)

    @Query("SELECT * FROM todo_list_table")
    fun getAllLists(): LiveData<TodoList>
}