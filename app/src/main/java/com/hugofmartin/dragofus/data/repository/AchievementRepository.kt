package com.hugofmartin.dragofus.data.repository

import com.hugofmartin.dragofus.data.database.DatabaseManager
import com.hugofmartin.dragofus.data.database.dao.AchievementDao
import com.hugofmartin.dragofus.data.entity.Achievement

interface AchievementRepository {
    suspend fun incrementCoupling()
    suspend fun incrementBirth()
    suspend fun getNbBirth(): Int
    suspend fun getNbCoupling(): Int
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
    override suspend fun incrementCoupling() {
        achievementDao.incrementCoupling()
    }

    override suspend fun incrementBirth() {
        achievementDao.incrementBirth()
    }

    override suspend fun getNbBirth(): Int {
        return achievementDao.getNbBirth()
    }

    override suspend fun getNbCoupling(): Int {
        return achievementDao.getNbCoupling()
    }

    override suspend fun createAchievement(achievement: Achievement) {
        achievementDao.insert(achievement)
    }

}
