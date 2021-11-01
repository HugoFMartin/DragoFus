package com.hugofmartin.dragofus.ui.main_screen.achievement

import androidx.lifecycle.*
import com.hugofmartin.dragofus.data.entity.Achievement
import com.hugofmartin.dragofus.data.repository.AchievementRepository
import com.hugofmartin.dragofus.ui.initialize_screen.fragment.initialize_setup.InitializeSetupViewModel

class AchievementViewModel (
    achievementRepository: AchievementRepository
) : ViewModel() {

    var appAchievement: LiveData<Achievement> = achievementRepository.getAppAchievement().asLiveData()

    companion object Factory : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return AchievementViewModel(AchievementRepository.newInstance()) as T
        }
    }
}