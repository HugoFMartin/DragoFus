package com.hugofmartin.dragofus.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.hugofmartin.dragofus.data.entity.Achievement
import kotlinx.coroutines.flow.Flow

@Dao
interface AchievementDao {
    @Query("UPDATE achievement SET nbCoupling = nbCoupling + 1 WHERE id = :id")
    fun incrementCoupling(id: Int)

    @Query("UPDATE achievement SET nbBirth = nbBirth + 1 WHERE id = :id")
    fun incrementBirth(id: Int)

    @Query("SELECT * FROM achievement WHERE id = :id")
    fun getAppAchievement(id: Int): Flow<Achievement>

    @Insert
    fun insert(entities: Achievement)
}