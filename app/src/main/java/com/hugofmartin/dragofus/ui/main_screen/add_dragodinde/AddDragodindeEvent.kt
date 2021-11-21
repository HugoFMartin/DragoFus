package com.hugofmartin.dragofus.ui.main_screen.add_dragodinde

import com.hugofmartin.dragofus.data.entity.Gender
import com.hugofmartin.dragofus.data.entity.Race

sealed class AddDragodindeEvent {
    data class OnNameChanged(val name: String): AddDragodindeEvent()
    data class OnRaceChanged(val race: Race): AddDragodindeEvent()
    data class OnNbCouplingChanged(val nbCoupling: Int): AddDragodindeEvent()
    data class OnGenderChanged(val gender: Gender): AddDragodindeEvent()
    data class OnFertileChanged(val isFertile: Boolean): AddDragodindeEvent()
    data class OnBornFromCouplingChanged(val isBornFromCoupling: Boolean): AddDragodindeEvent()
    object AddDragodinde: AddDragodindeEvent()
}