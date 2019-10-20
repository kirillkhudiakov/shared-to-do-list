package khudiakov.kirill.sharedtodolist.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_list_table")
class TodoList {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L

    @ColumnInfo(name = "list_name")
    var listName: String = ""

    @ColumnInfo(name = "total_items")
    var totalItems: Int = 0

    @ColumnInfo(name = "completed_items")
    var completedItems: Int = 0
}