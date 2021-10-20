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
    var isImpregnated: Boolean = false,
    val couplingNb: Int,
    val isFertile: Boolean,
    val gestation: Int,
    val isSterile: Boolean = false
)
