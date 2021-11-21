package com.hugofmartin.dragofus.ui.main_screen.list_dragodinde

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.hugofmartin.dragofus.ui.adapter.DragodindeAdapter
import com.hugofmartin.dragofus.R
import com.hugofmartin.dragofus.common.DragodindeFilter
import kotlinx.android.synthetic.main.list_dragodinde_fragment.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ListDragodindeFragment: Fragment() {

    private lateinit var dragodindeViewModel: ListDragodindeViewModel
    private lateinit var dragodindeAdapter: DragodindeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.run {
            dragodindeViewModel = ViewModelProvider(this, ListDragodindeViewModel).get(
                ListDragodindeViewModel::class.java)
        } ?: throw IllegalStateException("Invalid Activity")


        return inflater.inflate(R.layout.list_dragodinde_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            dragodindeViewModel.eventFlow.collectLatest { event ->
                when(event) {
                    is ListDragodindeEventUI.ToggleFilter -> {
                        filter_constraintLayout.visibility = if (dragodindeViewModel.listDragodindeState.isFilterDragodindeVisible) View.VISIBLE else View.GONE
                    }
                }
            }
        }

        dragodindeAdapter = DragodindeAdapter()

        dragodinde_list_recyclerView.apply {
            adapter = dragodindeAdapter
            layoutManager = GridLayoutManager(context, 1)
        }
        dragodindeAdapter.submitList(dragodindeViewModel.listDragodindeState.dragodindes)


        toggle_filter_constraintLayout.setOnClickListener { 
            dragodindeViewModel.onEvent(ListDragodindeEvent.ToggleDragodindeFilter)
        }
        
        male_filter_checkBox.setOnClickListener {
            dragodindeViewModel.onEvent(ListDragodindeEvent.OnFilter(DragodindeFilter.Male))
        }
        female_filter_checkBox.setOnClickListener {
            dragodindeViewModel.onEvent(ListDragodindeEvent.OnFilter(DragodindeFilter.Female))
        }
        sterile_filter_checkBox.setOnClickListener {
            dragodindeViewModel.onEvent(ListDragodindeEvent.OnFilter(DragodindeFilter.Sterile))
        }
        pregnant_filter_checkBox.setOnClickListener {
            dragodindeViewModel.onEvent(ListDragodindeEvent.OnFilter(DragodindeFilter.Pregnant))
        }
        fertile_filter_checkBox.setOnClickListener {
            dragodindeViewModel.onEvent(ListDragodindeEvent.OnFilter(DragodindeFilter.Fertile))
        }
        not_fertile_filter_checkBox.setOnClickListener {
            dragodindeViewModel.onEvent(ListDragodindeEvent.OnFilter(DragodindeFilter.NotFertile))
        }

        go_to_add_dragodinde_button.setOnClickListener {
            findNavController().navigate(R.id.action_listDragodindeFragment_to_addDragodindeFragment)
        }
    }
}