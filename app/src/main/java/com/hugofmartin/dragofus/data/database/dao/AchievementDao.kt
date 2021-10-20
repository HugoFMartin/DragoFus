package com.hugofmartin.dragofus.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.hugofmartin.dragofus.data.entity.Achievement

@Dao
interface AchievementDao {
    @Query("UPDATE achievement SET nbCoupling = nbCoupling + 1 WHERE id = 1")
    fun incrementCoupling()

    @Query("UPDATE achievement SET nbBirth = nbBirth + 1 WHERE id = 1")
    fun incrementBirth()

    @Query("SELECT nbBirth FROM achievement WHERE id = 1")
    fun getNbBirth(): Int

    @Query("SELECT nbCoupling FROM achievement WHERE id = 1")
    fun getNbCoupling(): Int

    @Insert
    fun insert(entities: Achievement)
}