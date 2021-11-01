package com.hugofmartin.dragofus.ui.initialize_screen.fragment.initialize_setup

import androidx.lifecycle.*
import com.hugofmartin.dragofus.common.Constants
import com.hugofmartin.dragofus.data.entity.Achievement
import com.hugofmartin.dragofus.data.entity.AchievementException
import com.hugofmartin.dragofus.data.repository.AchievementRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class InitializeSetupViewModel(
    private val achievementRepository: AchievementRepository
) : ViewModel() {

    private val _nbCoupling = InitializeSetupInputFieldState()
    val nbCoupling = _nbCoupling

    private val _nbBirth = InitializeSetupInputFieldState()
    val nbBirth = _nbBirth

    private val _eventFlow = MutableSharedFlow<InitializeSetupUiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event: InitializeSetupEvent) {
        when (event) {
            is InitializeSetupEvent.EnteredNbCoupling -> {
                if (event.value.isNotBlank()) {
                    _nbCoupling.number = event.value.toInt()
                    _nbCoupling.isValid = _nbCoupling.number <= 1000
                } else _nbCoupling.isValid = false
            }
            is InitializeSetupEvent.EnteredNbBirth -> {
                if (event.value.isNotBlank()) {
                    _nbBirth.number = event.value.toInt()
                    _nbBirth.isValid = _nbBirth.number <= 1000
                } else _nbBirth.isValid = false
            }
            is InitializeSetupEvent.ValidateAchievement -> {
                viewModelScope.launch {
                    try {
                        if (_nbBirth.isValid && _nbCoupling.isValid) {
                            achievementRepository.createAchievement(
                                Achievement(
                                    id = Constants.ACHIEVEMENT_ID,
                                    nbCoupling = nbCoupling.number,
                                    nbBirth = nbBirth.number
                                )
                            )
                            _eventFlow.emit(InitializeSetupUiEvent.SaveAchievement)
                        } else {
                            _eventFlow.emit(
                                InitializeSetupUiEvent.ShowToast(
                                    "Les valeurs doivent êtres non nulles et comprises entre 0 et 1000"
                                )
                            )
                        }
                    } catch (e: AchievementException) {
                        _eventFlow.emit(
                            InitializeSetupUiEvent.ShowToast(
                                e.message ?: "Les valeurs n'ont pas pu être enregistrées"
                            )
                        )
                    }
                }
            }
        }
    }


    companion object Factory : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return InitializeSetupViewModel(AchievementRepository.newInstance()) as T
        }
    }
}
