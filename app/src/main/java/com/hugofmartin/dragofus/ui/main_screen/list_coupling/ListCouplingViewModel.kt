package com.hugofmartin.dragofus.ui.main_screen.list_coupling

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hugofmartin.dragofus.data.entity.Coupling
import com.hugofmartin.dragofus.data.repository.CouplingRepository
import kotlinx.coroutines.flow.*

class ListCouplingViewModel(
    private val couplingRepository: CouplingRepository
) : ViewModel() {

    fun getCouplings() : Flow<List<Coupling>>{
        return couplingRepository.allCouplings
    }

    companion object Factory : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ListCouplingViewModel(CouplingRepository.newInstance()) as T
        }
    }
}