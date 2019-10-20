package khudiakov.kirill.sharedtodolist.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import khudiakov.kirill.sharedtodolist.databinding.OverviewListItemBinding
import khudiakov.kirill.sharedtodolist.repository.ListOverview

class OverviewListAdapter(private val dataset: List<ListOverview>) :
    RecyclerView.Adapter<OverviewListAdapter.OverviewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OverviewViewHolder {
        return OverviewViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: OverviewViewHolder, position: Int) {
        val item = dataset[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = dataset.size

    class OverviewViewHolder private constructor(private val binding: OverviewListItemBinding) :
            RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ListOverview) {
            binding.listName.text = item.name
            binding.listScore.text = item.score
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