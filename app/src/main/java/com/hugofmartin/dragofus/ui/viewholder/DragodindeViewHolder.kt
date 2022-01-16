package com.hugofmartin.dragofus.ui.viewholder

import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hugofmartin.dragofus.R
import com.hugofmartin.dragofus.data.entity.Dragodinde
import com.hugofmartin.dragofus.data.entity.Gender
import kotlinx.android.synthetic.main.dragodinde_view_holder.view.*

typealias OnDragodindeClickListener = (view: View, dragodinde: Dragodinde) -> Unit

class DragodindeViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(model: Dragodinde, ondragodindeClick: OnDragodindeClickListener) {

        itemView.apply {

            fun toggleDescription() {
                dragodinde_description_constraintLayout.visibility =
                    if (dragodinde_description_constraintLayout.visibility == View.VISIBLE) View.GONE else View.VISIBLE
                TransitionManager.beginDelayedTransition(dragodinde_constraintLayout)
            }

            dragodinde_imageViewHolder.setImageResource(model.race.getImage())
            dragodinde_name_textViewHolder.text = model.name
            dragodinde_coupling_nb_textViewHolder.text =
                resources.getString(R.string.nb_coupling_view_holder, model.nbCoupling.toString());
            dragodinde_race_textViewHolder.text = model.race.type

            dragodinde_constraintLayout.setOnClickListener {
                toggleDescription()
            }

            delete_dragodinde_imageButton.setOnClickListener {
                ondragodindeClick(it, model)
            }

            if (model.gender == Gender.FEMALE) {
                dragodinde_gender_imageViewHolder.setImageResource(R.drawable.female_24)

            } else {
                dragodinde_gender_imageViewHolder.setImageResource(R.drawable.male_30)
            }

            if (model.isPregnant) {
                is_coupling_textViewHolder.visibility = View.VISIBLE
            } else {
                is_coupling_textViewHolder.visibility = View.INVISIBLE
            }
            if (model.isFertile) {
                is_fertile_textViewHolder.visibility = View.VISIBLE
            } else {
                is_fertile_textViewHolder.visibility = View.INVISIBLE
            }
            if (model.nbCoupling == 0) {
                is_sterile_textViewHolder.visibility = View.VISIBLE
            } else {
                is_sterile_textViewHolder.visibility = View.INVISIBLE
            }


        }


    }


    companion object {
        /**
         * Create a new Instance of [DragodindeViewHolder]
         */
        fun create(parent: ViewGroup): DragodindeViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.dragodinde_view_holder,
                parent,
                false
            )
            return DragodindeViewHolder(view)
        }
    }
}