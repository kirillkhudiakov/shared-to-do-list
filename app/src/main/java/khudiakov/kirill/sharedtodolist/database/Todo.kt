package khudiakov.kirill.sharedtodolist.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
class Todo {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L

    @ColumnInfo
    var todoName: String = ""

    @ColumnInfo
    var completed: Boolean = false

    @ColumnInfo(name = "list_id")
    var listId: Long = 0L
}