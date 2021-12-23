package com.hugofmartin.dragofus.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coupling")
data class Coupling(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val maleRace: Race,
    val femaleRace: Race,
    val childRace: Race?,
    var finished: Boolean,
    var couplingDate: String
)
