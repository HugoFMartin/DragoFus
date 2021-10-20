package com.hugofmartin.dragofus.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.hugofmartin.dragofus.data.entity.Coupling
import kotlinx.coroutines.flow.Flow

@Dao
interface CouplingDao {
    @Query("SELECT * FROM coupling")
    fun getCouplings(): Flow<List<Coupling>>

    @Insert
    fun insert(entities: Coupling)

    @Query("UPDATE coupling SET finished= 1 WHERE id= :couplingId")
    fun makeCouplingFinished(couplingId: Int)

}