package com.hugofmartin.dragofus.data.entity

data class Coupling(
    val maleRace: Race,
    val femaleRace: Race,
    val childRace: Race,
    var finished: Boolean,
    var couplingDate: String
)
