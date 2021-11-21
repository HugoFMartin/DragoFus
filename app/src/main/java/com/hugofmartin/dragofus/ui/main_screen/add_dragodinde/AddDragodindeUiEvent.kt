package com.hugofmartin.dragofus.ui.main_screen.add_dragodinde

import com.hugofmartin.dragofus.data.entity.Race


sealed class AddDragodindeUiEvent {
    object OnDragodindeAdded: AddDragodindeUiEvent()
    data class OnDragodindeRaceChanged(var race: Race): AddDragodindeUiEvent()
}