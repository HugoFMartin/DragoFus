package com.hugofmartin.dragofus.ui.main_screen.list_dragodinde

import com.hugofmartin.dragofus.common.DragodindeFilter
import com.hugofmartin.dragofus.common.DragodindeSort
import com.hugofmartin.dragofus.data.entity.Dragodinde

sealed class ListDragodindeEvent {
    data class OnFilter(val filter: DragodindeFilter): ListDragodindeEvent()
    data class OnSort(val sorting: DragodindeSort): ListDragodindeEvent()
    data class DeleteDragodinde(val dragodinde: Dragodinde): ListDragodindeEvent()
    data class MakeFertileDragodinde(val dragodinde: Dragodinde): ListDragodindeEvent()
    object ToggleDragodindeFilter: ListDragodindeEvent()
}
