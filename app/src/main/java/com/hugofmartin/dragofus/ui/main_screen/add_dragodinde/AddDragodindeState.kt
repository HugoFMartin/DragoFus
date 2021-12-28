package com.hugofmartin.dragofus.ui.main_screen.add_dragodinde

import com.hugofmartin.dragofus.data.entity.Gender
import com.hugofmartin.dragofus.data.entity.Race

data class AddDragodindeState(
    var name: String = "Anonyme",
    var race: Race? = null,
    var nbCoupling: Int = 5,
    var gender: Gender = Gender.MALE,
    var isFertile: Boolean = false,
    var isBornFromCoupling: Boolean = true
) {

    fun reset(){
        name = "Anonyme"
        race = null
        nbCoupling = 5
        gender = Gender.MALE
        isFertile = false
        isBornFromCoupling= true
    }
}