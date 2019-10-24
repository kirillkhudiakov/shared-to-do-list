package khudiakov.kirill.sharedtodolist.overview

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import khudiakov.kirill.sharedtodolist.R
import khudiakov.kirill.sharedtodolist.database.TodoDatabase
import khudiakov.kirill.sharedtodolist.databinding.OverviewFragmentBinding
import khudiakov.kirill.sharedtodolist.util.ClickListener

class OverviewFragment : Fragment() {

    private lateinit var viewModel: OverviewViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(this.activity).application
        val database = TodoDatabase.getInstance(application)
        val todoListDao = database.todoListDao

        val viewModelFactory = OverviewViewModelFactory(todoListDao)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(OverviewViewModel::class.java)

        val binding: OverviewFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.overview_fragment, container, false
        )

        val viewManager = LinearLayoutManager(activity)

        val viewAdapter = OverviewListAdapter(ClickListener { id ->
            navigateToDetailFragment(id)
        })

        binding.overviewList.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        viewModel.lists.observe(this, Observer {
            viewAdapter.submitList(it)
        })

        binding.fab.setOnClickListener {
            val dialog = NewListDialog { viewModel.addList(it) }
            dialog.show(fragmentManager!!, "new_list_dialog")
        }

        return binding.root
    }

    private fun navigateToDetailFragment(listId: Long) {
        Log.i("OverviewFragment", "in naviagateToDetailFragment")
        findNavController().navigate(
            OverviewFragmentDirections.actionOverviewFragmentToDetailFragment(listId)
        )
    }
}
