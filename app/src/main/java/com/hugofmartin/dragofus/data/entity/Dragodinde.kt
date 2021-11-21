package com.hugofmartin.dragofus.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dragodinde")
data class Dragodinde(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val race: Race,
    val gender: Gender,
    var isPregnant: Boolean = false,
    val isFertile: Boolean,
    val nbCoupling: Int
)
