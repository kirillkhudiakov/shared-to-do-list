package khudiakov.kirill.sharedtodolist.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {

    @Insert
    fun insert(todo: Todo)

    @Query("SELECT * FROM todo_table WHERE list_id = :listId")
    fun getTodosFromList(listId: Long): LiveData<Todo>
}