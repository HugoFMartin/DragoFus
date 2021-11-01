package com.hugofmartin.dragofus.data.repository

import com.hugofmartin.dragofus.common.Constants
import com.hugofmartin.dragofus.data.database.DatabaseManager
import com.hugofmartin.dragofus.data.database.dao.AchievementDao
import com.hugofmartin.dragofus.data.entity.Achievement
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

interface AchievementRepository {
    fun getAppAchievement(): Flow<Achievement>
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

    override  fun getAppAchievement(): Flow<Achievement> {
        return achievementDao.getAppAchievement(Constants.ACHIEVEMENT_ID)
    }

    override suspend fun incrementCoupling() {
        withContext(Dispatchers.IO){
            achievementDao.incrementCoupling(Constants.ACHIEVEMENT_ID)
        }
    }

    override suspend fun incrementBirth() {
        withContext(Dispatchers.IO){
            achievementDao.incrementBirth(Constants.ACHIEVEMENT_ID)

        }
    }

    override suspend fun createAchievement(achievement: Achievement) {
        withContext(Dispatchers.IO){
            achievementDao.insert(achievement)
        }
    }
}
