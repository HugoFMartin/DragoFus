package com.hugofmartin.dragofus.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.hugofmartin.dragofus.data.entity.Dragodinde
import com.hugofmartin.dragofus.ui.viewholder.DragodindeViewHolder

class DragodindeAdapter: ListAdapter<Dragodinde, DragodindeViewHolder>(Companion) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DragodindeViewHolder {
        return DragodindeViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: DragodindeViewHolder, position: Int) {
        getItem(position)?.run { holder.bind(this) }
    }

    companion object : DiffUtil.ItemCallback<Dragodinde>() {
        override fun areItemsTheSame(oldItem: Dragodinde, newItem: Dragodinde): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Dragodinde, newItem: Dragodinde): Boolean {
            return oldItem == newItem
        }
    }
}