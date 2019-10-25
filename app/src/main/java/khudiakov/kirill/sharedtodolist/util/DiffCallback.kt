package khudiakov.kirill.sharedtodolist.util

import androidx.recyclerview.widget.DiffUtil
import khudiakov.kirill.sharedtodolist.database.BaseEntity

class DiffCallback<T : BaseEntity> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }
}