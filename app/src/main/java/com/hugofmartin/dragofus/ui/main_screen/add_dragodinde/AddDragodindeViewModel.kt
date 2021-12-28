package com.hugofmartin.dragofus.ui.main_screen.add_dragodinde


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.hugofmartin.dragofus.data.entity.Dragodinde
import com.hugofmartin.dragofus.data.repository.AchievementRepository
import com.hugofmartin.dragofus.data.repository.DragodindeRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class AddDragodindeViewModel(
    private val dragodindeRepository: DragodindeRepository,
    private val achievementRepository: AchievementRepository
    ) : ViewModel() {

    private var _addDragodindeState = AddDragodindeState()
    val addDragodindeState = _addDragodindeState

    private val _addDragodindeStateEventFlow = MutableSharedFlow<AddDragodindeUiEvent>()
    val addDragodindeStateEventFlow = _addDragodindeStateEventFlow.asSharedFlow()

    fun onEvent(event: AddDragodindeEvent) {
        when (event) {
            is AddDragodindeEvent.OnNameChanged -> {
                _addDragodindeState = _addDragodindeState.copy(
                    name = event.name
                )
            }
            is AddDragodindeEvent.OnRaceChanged -> {
                _addDragodindeState = _addDragodindeState.copy(
                    race = event.race
                )
                viewModelScope.launch {
                    _addDragodindeStateEventFlow.emit(AddDragodindeUiEvent.OnDragodindeRaceChanged(_addDragodindeState.race!!))
                }
            }
            is AddDragodindeEvent.OnFertileChanged -> {
                _addDragodindeState = _addDragodindeState.copy(
                    isFertile = event.isFertile
                )
            }
            is AddDragodindeEvent.OnGenderChanged -> {
                _addDragodindeState = _addDragodindeState.copy(
                    gender = event.gender
                )
            }
            is AddDragodindeEvent.OnNbCouplingChanged -> {
                _addDragodindeState = _addDragodindeState.copy(
                    nbCoupling = event.nbCoupling
                )
            }
            is AddDragodindeEvent.OnBornFromCouplingChanged -> {
                _addDragodindeState = _addDragodindeState.copy(
                    isBornFromCoupling = event.isBornFromCoupling
                )
            }
            is AddDragodindeEvent.AddDragodinde -> {
                viewModelScope.launch {
                    dragodindeRepository.addDragodinde(
                        Dragodinde(
                            0,
                            _addDragodindeState.name,
                            _addDragodindeState.race!!,
                            _addDragodindeState.gender,
                            false,
                            _addDragodindeState.isFertile,
                            _addDragodindeState.nbCoupling
                        )
                    )

                    if (_addDragodindeState.isBornFromCoupling) {
                        achievementRepository.incrementBirth()
                    }

                    _addDragodindeStateEventFlow.emit(AddDragodindeUiEvent.OnDragodindeAdded)
                    _addDragodindeState.reset()
                }
            }
        }
    }

    companion object Factory : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return AddDragodindeViewModel(DragodindeRepository.newInstance(), AchievementRepository.newInstance()) as T
        }
    }
}