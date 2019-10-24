package khudiakov.kirill.sharedtodolist.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
class Todo(@ColumnInfo(name = "todo_name") var todoName: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L

    var completed: Boolean = false

    @ColumnInfo(name = "list_id")
    var listId: Long = 0L
}

@Entity(tableName = "todo_list_table")
data class TodoList(@ColumnInfo(name = "list_name") var listName: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L


    @ColumnInfo(name = "total_items")
    var totalItems: Int = 0

    @ColumnInfo(name = "completed_items")
    var completedItems: Int = 0

//    override fun equals(other: Any?): Boolean {
//        return if (other is TodoList) id == other.id else false
//    }
//
//    override fun hashCode(): Int {
//        return id.hashCode()
//    }
}
