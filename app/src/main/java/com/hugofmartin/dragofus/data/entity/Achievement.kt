package com.hugofmartin.dragofus.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "achievement")
data class Achievement(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val nbCoupling: Int,
    val nbBirth: Int
)
