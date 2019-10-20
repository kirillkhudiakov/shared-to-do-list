package khudiakov.kirill.sharedtodolist.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import khudiakov.kirill.sharedtodolist.database.TodoList
import khudiakov.kirill.sharedtodolist.databinding.OverviewListItemBinding

class OverviewListAdapter :
    ListAdapter<TodoList, OverviewListAdapter.OverviewViewHolder>(TodoListDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OverviewViewHolder {
        return OverviewViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: OverviewViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class OverviewViewHolder private constructor(private val binding: OverviewListItemBinding) :
            RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TodoList) {
            binding.listName.text = item.listName
            binding.listScore.text = item.totalItems.toString()
        }

        companion object {
            fun from(parent: ViewGroup): OverviewViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = OverviewListItemBinding.inflate(inflater, parent, false)
                return OverviewViewHolder(binding)
            }
        }
    }
}

class TodoListDiffCallback : DiffUtil.ItemCallback<TodoList>() {
    override fun areItemsTheSame(oldItem: TodoList, newItem: TodoList): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TodoList, newItem: TodoList): Boolean {
        return oldItem == newItem
    }

}