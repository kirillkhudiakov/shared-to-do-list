package khudiakov.kirill.sharedtodolist.overview

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager

import khudiakov.kirill.sharedtodolist.R
import khudiakov.kirill.sharedtodolist.databinding.OverviewFragmentBinding

class OverviewFragment : Fragment() {

    private lateinit var viewModel: OverviewViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(OverviewViewModel::class.java)
        val binding: OverviewFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.overview_fragment, container, false
        )

        val viewManager = LinearLayoutManager(activity)
        val viewAdapter = OverviewListAdapter(listOf())
        binding.overviewList.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        return binding.root
    }
}
