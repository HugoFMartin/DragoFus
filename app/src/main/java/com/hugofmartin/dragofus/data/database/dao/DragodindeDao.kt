package com.hugofmartin.dragofus.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.hugofmartin.dragofus.data.entity.Dragodinde
import kotlinx.coroutines.flow.Flow

@Dao
interface DragodindeDao {
    @Query("SELECT * FROM dragodinde")
    fun getAll(): Flow<List<Dragodinde>>

    @Query("UPDATE dragodinde SET isFertile= 0 WHERE id= :dragodindeId")
    fun makeUnFertile(dragodindeId: Int)

    @Query("UPDATE dragodinde SET isFertile= 1 WHERE id= :dragodindeId")
    fun makeFertile(dragodindeId: Int)

    @Query("UPDATE dragodinde SET isPregnant= 1 WHERE id= :dragodindeId")
    fun makePregnant(dragodindeId: Int)

    @Query("UPDATE dragodinde SET couplingNb= couplingNb-1 WHERE id= :dragodindeId")
    fun decrementCoupling(dragodindeId: Int)

    @Delete
    fun delete(entities: Dragodinde)

    @Insert
    fun insert(entities: Dragodinde)
}