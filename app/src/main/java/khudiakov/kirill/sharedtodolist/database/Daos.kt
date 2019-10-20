package khudiakov.kirill.sharedtodolist.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BaseDao<T> {

    @Insert
    fun insert(item: T)
}

@Dao
interface TodoDao: BaseDao<Todo> {

    @Query("SELECT * FROM todo_table WHERE list_id = :listId")
    fun getTodosFromList(listId: Long): LiveData<List<Todo>>
}

@Dao
interface TodoListDao: BaseDao<TodoList> {

    @Query("SELECT * FROM todo_list_table")
    fun getAllLists(): LiveData<List<TodoList>>
}