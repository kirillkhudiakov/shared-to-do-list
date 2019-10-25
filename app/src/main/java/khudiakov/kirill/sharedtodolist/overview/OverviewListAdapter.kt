package khudiakov.kirill.sharedtodolist.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import khudiakov.kirill.sharedtodolist.util.ClickListener
import khudiakov.kirill.sharedtodolist.database.TodoList
import khudiakov.kirill.sharedtodolist.databinding.OverviewListItemBinding
import khudiakov.kirill.sharedtodolist.util.DiffCallback

class OverviewListAdapter(private val clickListener: ClickListener) :
    ListAdapter<TodoList, OverviewListAdapter.OverviewViewHolder>(DiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OverviewViewHolder {
        return OverviewViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: OverviewViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

    class OverviewViewHolder private constructor(private val binding: OverviewListItemBinding) :
            RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TodoList, clickListener: ClickListener) {
            binding.list = item
            binding.clickListener = clickListener
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