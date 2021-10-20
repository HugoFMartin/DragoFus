package com.hugofmartin.dragofus.data.entity

data class Dragodinde(
    val name: String,
    val race: Race,
    val gender: Gender,
    var isImpregnated: Boolean = false,
    val couplingNb: Int,
    val isFertile: Boolean,
    val gestation: Int,
    val isSterile: Boolean = false
)
