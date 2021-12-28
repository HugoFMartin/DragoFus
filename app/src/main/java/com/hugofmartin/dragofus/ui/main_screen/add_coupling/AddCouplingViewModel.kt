package com.hugofmartin.dragofus.ui.main_screen.add_coupling

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.hugofmartin.dragofus.data.entity.Coupling
import com.hugofmartin.dragofus.data.entity.Dragodinde
import com.hugofmartin.dragofus.data.entity.Race
import com.hugofmartin.dragofus.data.repository.CouplingRepository
import com.hugofmartin.dragofus.data.repository.DragodindeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import java.util.*

class AddCouplingViewModel(
    private val couplingRepository: CouplingRepository,
    private val dragodindeRepository: DragodindeRepository
) : ViewModel() {

    private val _eventFlow = MutableSharedFlow<AddCouplingEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun getMaleDragodindes(): Flow<List<Dragodinde>> {
        return dragodindeRepository.maleDragodindes
    }

    fun getFemaleDragodindes(): Flow<List<Dragodinde>> {
        return dragodindeRepository.femaleDragodindes
    }

    fun makeCoupling(male: Dragodinde, female: Dragodinde) {
        viewModelScope.launch {
            val newCoupling = Coupling(
                0,
                male.race,
                female.race,
                Race.getChild(male, female),
                false,
                Date().toString()
            )
            couplingRepository.addCoupling(newCoupling)
            onDragodindeCoupling(male, female)
        }
    }

    private suspend fun onDragodindeCoupling(male: Dragodinde, female: Dragodinde) {
        dragodindeRepository.makePregnant(female.id)
        dragodindeRepository.makeUnFertile(male.id)
        dragodindeRepository.makeUnFertile(female.id)
        dragodindeRepository.decrementCoupling(male.id)
        dragodindeRepository.decrementCoupling(female.id)
        _eventFlow.emit(AddCouplingEvent.OnCouplingAdded)
    }

    companion object Factory : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return AddCouplingViewModel(
                CouplingRepository.newInstance(),
                DragodindeRepository.newInstance()
            ) as T
        }
    }
}