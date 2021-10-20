package com.hugofmartin.dragofus.ui.viewmodel

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.lifecycle.*
import com.hugofmartin.dragofus.data.entity.Coupling
import com.hugofmartin.dragofus.data.repository.CouplingRepository
import kotlinx.coroutines.launch

class CouplingViewModel(
    private val couplingRepository: CouplingRepository
) : ViewModel() {

    var coupling = couplingRepository.allCouplings.asLiveData()

    fun addCoupling(coupling: Coupling) {
        viewModelScope.launch {
            couplingRepository.addCoupling(coupling)
        }
    }

    fun makeCouplingFinished(coupling: Coupling) {
        viewModelScope.launch {
            couplingRepository.makeCouplingFinished(coupling.id)
        }
    }

    companion object Factory : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return CouplingViewModel(CouplingRepository.newInstance()) as T
        }
    }
}