package com.hugofmartin.dragofus.ui.main_screen.add_dragodinde

import com.hugofmartin.dragofus.data.entity.Gender
import com.hugofmartin.dragofus.data.entity.Race

data class AddDragodindeState(
    val name: String = "Anonyme",
    val race: Race? = null,
    val nbCoupling: Int = 5,
    val gender: Gender = Gender.MALE,
    val isFertile: Boolean = false,
    val isBornFromCoupling: Boolean = true
) {
}