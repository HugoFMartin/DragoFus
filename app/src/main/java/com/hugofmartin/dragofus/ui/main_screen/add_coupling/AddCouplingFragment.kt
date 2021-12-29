package com.hugofmartin.dragofus.ui.main_screen.add_coupling

import DragodindeCouplingAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.hugofmartin.dragofus.R
import com.hugofmartin.dragofus.data.entity.Dragodinde
import kotlinx.android.synthetic.main.add_coupling_fragment.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


class AddCouplingFragment : Fragment() {

    private lateinit var femaleDragodindeAdapter: DragodindeCouplingAdapter
    private lateinit var maleDragodindeAdapter: DragodindeCouplingAdapter

    private lateinit var addCouplingViewModel: AddCouplingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.run {
            addCouplingViewModel = ViewModelProvider(this, AddCouplingViewModel).get(
                AddCouplingViewModel::class.java
            )
        } ?: throw IllegalStateException("Invalid Activity")


        return inflater.inflate(R.layout.add_coupling_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        femaleDragodindeAdapter = DragodindeCouplingAdapter(requireContext(), emptyList())
        maleDragodindeAdapter = DragodindeCouplingAdapter(requireContext(), emptyList())

        dragodinde_male_spinner.apply {
            adapter = maleDragodindeAdapter
        }
        dragodinde_female_spinner.apply {
            adapter = femaleDragodindeAdapter
        }

        viewLifecycleOwner.lifecycleScope.launch {
            addCouplingViewModel.getFemaleDragodindes()
                .onEach {
                    femaleDragodindeAdapter.submitList(it)
                    femaleDragodindeAdapter.notifyDataSetChanged()
                }
                .launchIn(this)
            addCouplingViewModel.getMaleDragodindes()
                .onEach {
                    maleDragodindeAdapter.submitList(it)
                    maleDragodindeAdapter.notifyDataSetChanged()
                }
                .launchIn(this)

            addCouplingViewModel.eventFlow.collectLatest {
                when (it) {
                    is AddCouplingEvent.OnCouplingAdded -> {
                        findNavController().popBackStack()
                    }
                }
            }
        }

        add_coupling_button.setOnClickListener {
            addCouplingViewModel.makeCoupling(
                maleDragodindeAdapter.getItem(dragodinde_male_spinner.selectedItemPosition) as Dragodinde,
                femaleDragodindeAdapter.getItem(dragodinde_female_spinner.selectedItemPosition) as Dragodinde,
                requireContext()
            )
        }


    }
}