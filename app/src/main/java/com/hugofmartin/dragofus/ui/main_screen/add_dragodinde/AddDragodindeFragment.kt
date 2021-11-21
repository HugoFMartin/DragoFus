package com.hugofmartin.dragofus.ui.main_screen.add_dragodinde

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.hugofmartin.dragofus.R
import com.hugofmartin.dragofus.data.entity.Gender
import com.hugofmartin.dragofus.data.entity.Race
import kotlinx.android.synthetic.main.add_dragodinde_fragment.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class AddDragodindeFragment :  Fragment(){

    private lateinit var addDragodindeViewModel: AddDragodindeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.run {
            addDragodindeViewModel = ViewModelProvider(this, AddDragodindeViewModel).get(AddDragodindeViewModel::class.java)
        } ?: throw IllegalStateException("Invalid Activity")
        return inflater.inflate(R.layout.add_dragodinde_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dragodindeRaceAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,
            Race.values().map{ it.type})

        dragodinde_race_auto_complete.setAdapter(dragodindeRaceAdapter)

        viewLifecycleOwner.lifecycleScope.launch {
            addDragodindeViewModel.addDragodindeStateEventFlow.collectLatest {
                when (it) {
                    is AddDragodindeUiEvent.OnDragodindeAdded -> {
                        findNavController().popBackStack()
                    }
                    is AddDragodindeUiEvent.OnDragodindeRaceChanged -> {
                        dragodinde_gestation_textView.text = it.race.getGestation().toString()
                        dragodinde_imageView.setImageResource(it.race.getImage())
                        add_dragodinde_button.isActivated = true
                    }
                }
            }
        }
        
        dragodinde_name_editText.doOnTextChanged { text, _, _, _ ->
            if(text.toString().isNotBlank()) {
                addDragodindeViewModel.onEvent(AddDragodindeEvent.OnNameChanged(text.toString()))
            }
        }

        dragodinde_coupling_nb_editText.doOnTextChanged { text, _, _, _ ->
            if(text.toString().isNotBlank()) {
                addDragodindeViewModel.onEvent(AddDragodindeEvent.OnNbCouplingChanged(text.toString().toInt()))
            }
        }

        male_radio_button.setOnClickListener {
            addDragodindeViewModel.onEvent(AddDragodindeEvent.OnGenderChanged(Gender.MALE))
        }
        female_radio_button.setOnClickListener {
            addDragodindeViewModel.onEvent(AddDragodindeEvent.OnGenderChanged(Gender.FEMALE))
        }
        dragodinde_is_fertile_switch.setOnCheckedChangeListener { _, isChecked ->
            addDragodindeViewModel.onEvent(AddDragodindeEvent.OnFertileChanged(isChecked))
        }
        dragodinde_is_from_coupling_switch.setOnCheckedChangeListener { _, isChecked ->
            addDragodindeViewModel.onEvent(AddDragodindeEvent.OnBornFromCouplingChanged(isChecked))
        }
        dragodinde_race_auto_complete.setOnItemClickListener{ _, _, pos, _ ->
            val race = Race.from(dragodindeRaceAdapter.getItem(pos)!!)
            addDragodindeViewModel.onEvent(AddDragodindeEvent.OnRaceChanged(race))
        }
        add_dragodinde_button.setOnClickListener {
            addDragodindeViewModel.onEvent(AddDragodindeEvent.AddDragodinde)
        }
    }
}