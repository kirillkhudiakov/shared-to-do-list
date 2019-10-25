package khudiakov.kirill.sharedtodolist.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

abstract class BaseEntity(@ColumnInfo(name = "name") var name: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L

    override fun equals(other: Any?): Boolean {
        return if (other is BaseEntity) id == other.id && name == other.name else false
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name)
    }
}

@Entity(tableName = "todo_table")
class Todo(name: String) : BaseEntity(name) {

    var completed: Boolean = false

    @ColumnInfo(name = "list_id")
    var listId: Long = 0L

    override fun equals(other: Any?): Boolean {
        val res = super.equals(other)
        if (!res)
            return false

        return if (other is Todo) completed == other.completed && listId == other.listId else false
    }

    override fun hashCode(): Int {
        return Objects.hash(super.hashCode(), completed, listId)
    }
}

@Entity(tableName = "todo_list_table")
class TodoList(name: String) : BaseEntity(name) {

    @ColumnInfo(name = "total_items")
    var totalItems: Int = 0

    @ColumnInfo(name = "completed_items")
    var completedItems: Int = 0

    override fun equals(other: Any?): Boolean {
        val res = super.equals(other)
        if (!res)
            return false

        return if (other is TodoList)
            totalItems == other.totalItems && completedItems == other.completedItems
        else
            false
    }

    override fun hashCode(): Int {
        return Objects.hash(super.hashCode(), totalItems, completedItems)
    }
}
