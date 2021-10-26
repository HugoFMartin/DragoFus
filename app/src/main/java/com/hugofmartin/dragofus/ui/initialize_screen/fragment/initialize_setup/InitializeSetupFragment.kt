package com.hugofmartin.dragofus.ui.initialize_screen.fragment.initialize_setup

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.hugofmartin.dragofus.R
import kotlinx.android.synthetic.main.initializing_setup_fragment.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class InitializeSetupFragment : Fragment() {

    private lateinit var initializeSetupViewModel: InitializeSetupViewModel

    private lateinit var nbCouplingState: InitializeSetupInputFieldState
    private lateinit var nbBirthState: InitializeSetupInputFieldState

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initializeSetupViewModel = ViewModelProvider(this, InitializeSetupViewModel).get(InitializeSetupViewModel::class.java)
        return inflater.inflate(R.layout.initializing_setup_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nbCouplingState = initializeSetupViewModel.nbCoupling
        nbBirthState = initializeSetupViewModel.nbBirth

        viewLifecycleOwner.lifecycleScope.launch {
            initializeSetupViewModel.eventFlow.collectLatest { event ->
                when(event) {
                    is InitializeSetupUiEvent.ShowToast -> {
                        Toast.makeText(requireContext(), event.message, Toast.LENGTH_SHORT).show()
                    }
                    is InitializeSetupUiEvent.SaveAchievement -> {
                        findNavController().navigate(R.id.action_initializeSetupFragment_to_initializeEndFragment)
                    }
                }
            }
        }


        validate_initializing_button.setOnClickListener {
           initializeSetupViewModel.onEvent(InitializeSetupEvent.ValidateAchievement)
        }


        nb_coupling_initializing_editTextNumber.apply {
            doOnTextChanged { text, _, _, _ ->
                initializeSetupViewModel.onEvent(InitializeSetupEvent.EnteredNbCoupling(text.toString()))
            }
        }.setText(nbCouplingState.number.toString())

        nb_birth_initializing_editTextNumber.apply {
            doOnTextChanged { text, _, _, _ ->
                initializeSetupViewModel.onEvent(InitializeSetupEvent.EnteredNbBirth(text.toString()))
            }
        }.setText(nbBirthState.number.toString())
    }
}