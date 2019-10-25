package khudiakov.kirill.sharedtodolist.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import khudiakov.kirill.sharedtodolist.database.Todo
import khudiakov.kirill.sharedtodolist.databinding.DetailListItemBinding
import khudiakov.kirill.sharedtodolist.util.DiffCallback

class DetailListAdapter()
    : ListAdapter<Todo, DetailListAdapter.TodoViewHolder>(DiffCallback<Todo>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TodoViewHolder private constructor (private val binding: DetailListItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Todo) {
            binding.todo = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup) : TodoViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = DetailListItemBinding.inflate(inflater, parent, false)
                return TodoViewHolder(binding)
            }
        }
    }
}