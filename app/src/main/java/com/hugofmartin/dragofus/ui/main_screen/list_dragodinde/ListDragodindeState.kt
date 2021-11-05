package com.hugofmartin.dragofus.ui.main_screen.list_dragodinde

import com.hugofmartin.dragofus.common.DragodindeFilter
import com.hugofmartin.dragofus.common.DragodindeSort
import com.hugofmartin.dragofus.data.entity.Dragodinde

data class ListDragodindeState(
    var dragodindes: List<Dragodinde> = emptyList(),
    val filters: MutableList<DragodindeFilter> = mutableListOf(),
    var sorting: DragodindeSort = DragodindeSort.SortByRace,
    var isFilterDragodindeVisible: Boolean = false
)