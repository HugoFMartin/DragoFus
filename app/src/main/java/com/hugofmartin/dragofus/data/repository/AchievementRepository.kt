package com.hugofmartin.dragofus.data.repository

import com.hugofmartin.dragofus.common.Constants
import com.hugofmartin.dragofus.data.database.DatabaseManager
import com.hugofmartin.dragofus.data.database.dao.AchievementDao
import com.hugofmartin.dragofus.data.entity.Achievement
import kotlinx.coroutines.flow.Flow

interface AchievementRepository {
    val appAchievement: Flow<Achievement>
    suspend fun incrementCoupling()
    suspend fun incrementBirth()
    suspend fun createAchievement(achievement: Achievement)

    companion object {
        fun newInstance(): AchievementRepository =
            AchievementRepositoryImpl(
                DatabaseManager.getInstance().database.achievementsDao
            )
    }
}

class AchievementRepositoryImpl(
    private val achievementDao: AchievementDao
) : AchievementRepository {

    override val appAchievement = achievementDao.getAppAchievement(Constants.ACHIEVEMENT_ID)

    override suspend fun incrementCoupling() {
        achievementDao.incrementCoupling(Constants.ACHIEVEMENT_ID)
    }

    override suspend fun incrementBirth() {
        achievementDao.incrementBirth(Constants.ACHIEVEMENT_ID)
    }

    override suspend fun createAchievement(achievement: Achievement) {
        achievementDao.insert(achievement)
    }
}
