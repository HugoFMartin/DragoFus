package com.hugofmartin.dragofus.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.hugofmartin.dragofus.data.entity.Achievement
import com.hugofmartin.dragofus.data.repository.AchievementRepository
import kotlinx.coroutines.launch

class AchievementViewModel(
    private val achievementRepository: AchievementRepository
): ViewModel() {

    val appAchievement = achievementRepository.appAchievement.asLiveData()

    fun incrementNbBirth() {
        viewModelScope.launch {
            achievementRepository.incrementBirth()
        }
    }

    fun incrementNbCoupling() {
        viewModelScope.launch {
            achievementRepository.incrementCoupling()
        }
    }

    fun insertAchievements(achievement: Achievement) {
        viewModelScope.launch {
            achievementRepository.createAchievement(achievement)
        }
    }

    companion object Factory : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return AchievementViewModel(AchievementRepository.newInstance()) as T
        }
    }
}
