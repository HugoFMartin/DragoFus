package com.hugofmartin.dragofus.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.hugofmartin.dragofus.data.entity.Coupling

@Dao
interface CouplingDao {
    @Query("SELECT * FROM coupling")
    fun getCouplings(): List<Coupling>

    @Query("SELECT * FROM coupling WHERE finished = 1")
    fun getFinishedCouplings(): List<Coupling>

    @Query("UPDATE coupling SET finished= 1 WHERE id= :couplingId")
    fun makeCouplingFinished(couplingId: Int)

    @Insert
    fun insert(entities: Coupling): Long
}