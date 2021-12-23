package com.hugofmartin.dragofus.ui.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.hugofmartin.dragofus.R

class DragodindeCouplingViewHolder (
    row: View?
) {
    val name : TextView = row!!.findViewById(R.id.dragodinde_name_coupling_textViewHolder)
    val image: ImageView = row!!.findViewById(R.id.dragodinde_coupling_imageViewHolder)
    val couplingNb: TextView = row!!.findViewById(R.id.dragodinde_nb_coupling_coupling_textViewHolder)
}