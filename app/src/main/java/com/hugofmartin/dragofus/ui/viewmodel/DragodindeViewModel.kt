package com.hugofmartin.dragofus.ui.viewmodel

import androidx.lifecycle.*
import com.hugofmartin.dragofus.data.entity.Dragodinde
import com.hugofmartin.dragofus.data.repository.DragodindeRepository
import kotlinx.coroutines.launch

class DragodindeViewModel(
    private val dragodindeRepository: DragodindeRepository
) : ViewModel() {

    var dragodindes: LiveData<List<Dragodinde>> = dragodindeRepository.allDragodindes.asLiveData()

    fun addDragodinde(dragodinde: Dragodinde) {
        viewModelScope.launch {
            dragodindeRepository.addDragodinde(dragodinde)
        }
    }

    fun makeUnFertile(dragodindeId: Int) {
        viewModelScope.launch {
            dragodindeRepository.makeUnFertile(dragodindeId)
        }
    }

    fun makeImpregnated(femaleDragodindeId: Int) {
        viewModelScope.launch {
            dragodindeRepository.makeImpregnated(femaleDragodindeId)
        }
    }

    fun decrementCoupling(dragodindeId: Int) {
        viewModelScope.launch {
            dragodindeRepository.decrementCoupling(dragodindeId)
        }
    }

    companion object Factory : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return DragodindeViewModel(DragodindeRepository.newInstance()) as T
        }
    }
}