package com.hugofmartin.dragofus.ui.main_screen.list_coupling

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.hugofmartin.dragofus.R
import kotlinx.android.synthetic.main.home_dragodinde_fragment.*

class ListCouplingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.run {
        } ?: throw IllegalStateException("Invalid Activity")


        return inflater.inflate(R.layout.list_coupling, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


    }
}