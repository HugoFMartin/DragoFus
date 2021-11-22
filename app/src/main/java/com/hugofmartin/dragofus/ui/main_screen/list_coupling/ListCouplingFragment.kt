package com.hugofmartin.dragofus.ui.main_screen.list_coupling

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.hugofmartin.dragofus.R
import com.hugofmartin.dragofus.data.entity.Coupling
import com.hugofmartin.dragofus.ui.adapter.CouplingAdapter
import kotlinx.android.synthetic.main.home_dragodinde_fragment.*
import kotlinx.android.synthetic.main.list_coupling.*
import kotlinx.coroutines.launch

class ListCouplingFragment : Fragment() {

    private lateinit var listCouplingAdapter: CouplingAdapter
    private lateinit var couplingViewModel: ListCouplingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.run {
            couplingViewModel = ViewModelProvider(this, ListCouplingViewModel).get(
                ListCouplingViewModel::class.java
            )
        } ?: throw IllegalStateException("Invalid Activity")


        return inflater.inflate(R.layout.list_coupling, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        listCouplingAdapter = CouplingAdapter()
        list_coupling_recyclerView.apply {
            adapter = listCouplingAdapter
            layoutManager = GridLayoutManager(context,1)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            val couplingList = couplingViewModel.getCouplings() as MutableList<Coupling>
            listCouplingAdapter.submitList(couplingList)
        }

    }
}