package com.hugofmartin.dragofus.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.hugofmartin.dragofus.data.entity.Coupling
import com.hugofmartin.dragofus.ui.viewholder.CouplingViewHolder

class CouplingAdapter : ListAdapter<Coupling, CouplingViewHolder>(Companion) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CouplingViewHolder {
        return CouplingViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CouplingViewHolder, position: Int) {
        getItem(position)?.run { holder.bind(this) }
    }

    companion object : DiffUtil.ItemCallback<Coupling>() {
        override fun areItemsTheSame(oldItem: Coupling, newItem: Coupling): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Coupling, newItem: Coupling): Boolean {
            return oldItem == newItem
        }
    }
}