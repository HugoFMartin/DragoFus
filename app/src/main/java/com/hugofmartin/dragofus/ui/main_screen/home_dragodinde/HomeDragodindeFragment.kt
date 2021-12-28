package com.hugofmartin.dragofus.ui.main_screen.home_dragodinde

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hugofmartin.dragofus.R
import kotlinx.android.synthetic.main.home_dragodinde_fragment.*

class HomeDragodindeFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.run {
        } ?: throw IllegalStateException("Invalid Activity")


        return inflater.inflate(R.layout.home_dragodinde_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        go_to_list_dragodinde_button.setOnClickListener {
            findNavController().navigate(R.id.action_homeDragodindeFragment_to_listDragodindeFragment)

        }

        go_to_list_coupling_button.setOnClickListener {
            findNavController().navigate(R.id.action_homeDragodindeFragment_to_listCouplingFragment)
        }

        go_to_achievement_button.setOnClickListener {
            findNavController().navigate(R.id.action_homeDragodindeFragment_to_achievementFragment)
        }

    }
}