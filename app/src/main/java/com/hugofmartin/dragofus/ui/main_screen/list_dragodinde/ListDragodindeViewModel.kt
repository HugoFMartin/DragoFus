package com.hugofmartin.dragofus.ui.main_screen.list_dragodinde

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.hugofmartin.dragofus.common.DragodindeFilter
import com.hugofmartin.dragofus.common.DragodindeSort
import com.hugofmartin.dragofus.data.entity.Dragodinde
import com.hugofmartin.dragofus.data.entity.Gender
import com.hugofmartin.dragofus.data.repository.DragodindeRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class ListDragodindeViewModel(
    private val dragodindeRepository: DragodindeRepository
):ViewModel() {

    private val _listDragodindeState = ListDragodindeState()
    val listDragodindeState = _listDragodindeState

    private var getDragodindesJob: Job? = null

    private val _eventFlow = MutableSharedFlow<ListDragodindeEventUI>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        getDragodindes()
    }

    fun onEvent(event: ListDragodindeEvent){
        when(event) {
            is ListDragodindeEvent.OnFilter -> {
                toggleFilter(event.filter)
                getDragodindes()
            }
            is ListDragodindeEvent.MakeFertileDragodinde -> {
                viewModelScope.launch {
                    dragodindeRepository.makeFertile(event.dragodinde.id)
                }
            }
            is ListDragodindeEvent.DeleteDragodinde -> {
                viewModelScope.launch {
                    dragodindeRepository.deleteDragodinde(event.dragodinde)
                }
            }
            is ListDragodindeEvent.ToggleDragodindeFilter -> {
                _listDragodindeState.isFilterDragodindeVisible = !_listDragodindeState.isFilterDragodindeVisible
                viewModelScope.launch {
                    _eventFlow.emit(ListDragodindeEventUI.ToggleFilter)
                }
            }
            is ListDragodindeEvent.OnSort -> {
                _listDragodindeState.sorting = event.sorting
            }
        }
    }

    private fun getDragodindes() {
        getDragodindesJob?.cancel()
        getDragodindesJob = dragodindeRepository.allDragodindes
            .onEach { dragodindes ->
                _listDragodindeState.filters.forEach {
                    applyFilter(it, dragodindes)
                }
                applySort(_listDragodindeState.sorting, dragodindes)
                _listDragodindeState.dragodindes = dragodindes
            }
            .launchIn(viewModelScope)
    }

    private fun applyFilter(filter: DragodindeFilter, dragodindes: List<Dragodinde>){
        when (filter) {
            is DragodindeFilter.Male -> dragodindes.filter { it.gender == Gender.MALE }
            is DragodindeFilter.Female -> dragodindes.filter { it.gender == Gender.FEMALE }
            is DragodindeFilter.Fertile -> dragodindes.filter { it.isFertile }
            is DragodindeFilter.Sterile -> dragodindes.filter { !it.isFertile }
            is DragodindeFilter.Pregnant -> dragodindes.filter { it.isPregnant }
            is DragodindeFilter.NotFertile -> dragodindes.filter { !it.isPregnant }
        }
    }
    private fun applySort(sorting: DragodindeSort, dragodindes: List<Dragodinde>){
        when (sorting) {
            is DragodindeSort.SortByRace -> dragodindes.sortedByDescending { it.race.name }
            is DragodindeSort.SortByName -> dragodindes.sortedByDescending { it.name }
        }
    }

    private fun toggleFilter(filter: DragodindeFilter) {
        if (_listDragodindeState.filters.contains(filter)) {
            _listDragodindeState.filters.add(filter)
        } else {
            _listDragodindeState.filters.remove(filter)
        }
    }

    companion object Factory : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ListDragodindeViewModel(DragodindeRepository.newInstance()) as T
        }
    }
}