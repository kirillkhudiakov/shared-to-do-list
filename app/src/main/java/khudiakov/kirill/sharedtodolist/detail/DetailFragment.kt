package khudiakov.kirill.sharedtodolist.detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import khudiakov.kirill.sharedtodolist.R
import khudiakov.kirill.sharedtodolist.database.TodoDatabase
import khudiakov.kirill.sharedtodolist.databinding.DetailFragmentBinding
import khudiakov.kirill.sharedtodolist.databinding.OverviewFragmentBinding

class DetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: DetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.detail_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val listId = DetailFragmentArgs.fromBundle(arguments!!).listId

        val application = requireNotNull(activity).application
        val database = TodoDatabase.getInstance(application)
        val todoDao = database.todoDao

        val factory = DetailViewModelFactory(listId, todoDao)
        viewModel = ViewModelProviders.of(this, factory).get(DetailViewModel::class.java)

        val adapter = DetailListAdapter()
        binding.detailList.adapter = adapter
        viewModel.todos.observe(this, Observer { adapter.submitList(it) })
    }
}
