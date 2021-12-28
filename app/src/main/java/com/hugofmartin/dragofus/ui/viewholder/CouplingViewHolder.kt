package com.hugofmartin.dragofus.ui.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hugofmartin.dragofus.R
import com.hugofmartin.dragofus.data.entity.Coupling
import com.hugofmartin.dragofus.data.entity.Gender
import kotlinx.android.synthetic.main.coupling_view_holder.view.*
import kotlinx.android.synthetic.main.dragodinde_view_holder.view.*

class CouplingViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(model: Coupling) {
        itemView.apply {
            male_dragodinde_imageViewHolder.setImageResource(model.maleRace.getImage())
            male_dragodinde_race_textView.text = model.maleRace.type
            //male_dragodinde_name_textView.text
            female_dragodinde_imageViewHolder.setImageResource(model.femaleRace.getImage())
            female_dragodinde_race_textView.text = model.femaleRace.type
            //female_dragodinde_name_textView.text
        }
    }

    companion object {
        /**
         * Create a new Instance of [CouplingViewHolder]
         */
        fun create(parent: ViewGroup): CouplingViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.coupling_view_holder,
                parent,
                false
            )
            return CouplingViewHolder(view)
        }
    }
}