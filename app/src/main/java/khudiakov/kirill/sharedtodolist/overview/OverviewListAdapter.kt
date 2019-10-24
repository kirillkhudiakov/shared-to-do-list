package khudiakov.kirill.sharedtodolist.overview

import android.util.Log
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
        Log.i("OverviewListAdapter", "Created new view holder")
        return OverviewViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: OverviewViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        Log.i("OverviewListAdapter", "Bind view holder")
    }

    class OverviewViewHolder private constructor(private val binding: OverviewListItemBinding) :
            RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TodoList) {
            binding.listName.text = item.listName
            binding.listScore.text = item.totalItems.toString()
            binding.executePendingBindings()
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
        Log.i("OverviewListAdapter", "Items are the same = ${oldItem.id == newItem.id}")
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: TodoList, newItem: TodoList): Boolean {
        Log.i("OverviewListAdapter", "Contents are the same = ${oldItem == newItem}")
        return oldItem == newItem
    }

}