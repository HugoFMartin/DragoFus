package com.hugofmartin.dragofus.ui.main_screen.list_coupling

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.hugofmartin.dragofus.R
import com.hugofmartin.dragofus.ui.adapter.CouplingAdapter
import kotlinx.android.synthetic.main.list_coupling_fragment.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class ListCouplingFragment : Fragment() {

    private lateinit var listCouplingAdapter: CouplingAdapter
    private lateinit var listCouplingViewModel: ListCouplingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.run {
            listCouplingViewModel = ViewModelProvider(this, ListCouplingViewModel).get(
                ListCouplingViewModel::class.java
            )
        } ?: throw IllegalStateException("Invalid Activity")


        return inflater.inflate(R.layout.list_coupling_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        go_to_add_coupling_button.setOnClickListener {
            findNavController().navigate(R.id.action_listCouplingFragment_to_addCouplingFragment)
        }

        listCouplingAdapter = CouplingAdapter()
        list_coupling_recyclerView.apply {
            adapter = listCouplingAdapter
            layoutManager = GridLayoutManager(context,1)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            listCouplingViewModel.getCouplings()
                .onEach {
                    listCouplingAdapter.submitList(it)
                    listCouplingAdapter.notifyDataSetChanged()
                }
                .launchIn(this)
        }

    }
}