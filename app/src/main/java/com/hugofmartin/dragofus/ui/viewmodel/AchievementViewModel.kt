package com.hugofmartin.dragofus.ui.viewmodel

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.hugofmartin.dragofus.common.Constants
import com.hugofmartin.dragofus.data.entity.Achievement
import com.hugofmartin.dragofus.data.entity.AchievementException
import com.hugofmartin.dragofus.data.repository.AchievementRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class AchievementViewModel(
    private val achievementRepository: AchievementRepository
) : ViewModel() {

    val appAchievement = achievementRepository.appAchievement.asLiveData()

    fun insertAppAchievement(nbCoupling: String, nbBirth: String) {
        val achievement = Achievement(Constants.ACHIEVEMENT_ID, nbCoupling.toInt(), nbBirth.toInt())
        insertAchievements(achievement)
    }

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

    private fun insertAchievements(achievement: Achievement) {
        viewModelScope.launch {
            try {
                achievementRepository.createAchievement(achievement)
            } catch (e: AchievementException) {

            }

        }
    }

    fun checkAchievementValues(nbCoupling: String, nbBirth: String): Boolean {
        return if ( nbCoupling.isBlank() || nbBirth.isBlank()) {
            false
        } else !(nbCoupling.toInt() < 0 || nbBirth.toInt() < 0)
    }

    companion object Factory : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return AchievementViewModel(AchievementRepository.newInstance()) as T
        }
    }
}
