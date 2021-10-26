package com.hugofmartin.dragofus.ui.initialize_screen.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hugofmartin.dragofus.R
import kotlinx.android.synthetic.main.initializing_home_fragment.*


class InitializeHomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.initializing_home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        go_to_initializing_setup_button.setOnClickListener{
            findNavController().navigate(R.id.action_initializeHomeFragment_to_initializeSetupFragment)
        }

        go_to_initializing_end_button.setOnClickListener{
            findNavController().navigate(R.id.action_initializeHomeFragment_to_initializeEndFragment)
        }

    }
}