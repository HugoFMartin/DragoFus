package com.hugofmartin.dragofus.data.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hugofmartin.dragofus.common.Constants
import com.hugofmartin.dragofus.data.entity.Achievement
import com.hugofmartin.dragofus.data.entity.Coupling
import com.hugofmartin.dragofus.data.entity.Dragodinde
import com.hugofmartin.dragofus.ui.DragoFusApplication

@Database(entities = [Dragodinde::class, Coupling::class, Achievement::class], exportSchema = false, version = 1)
abstract class MyDragoFusDatabase : RoomDatabase() {
}

class DatabaseManagerImpl(override val database: MyDragoFusDatabase) : DatabaseManager

interface DatabaseManager {
    val database: MyDragoFusDatabase

    companion object {
        @Volatile
        private var databaseManager: DatabaseManager? = null

        fun getInstance(app: DragoFusApplication? = null): DatabaseManager {
            return databaseManager ?: synchronized(this) {
                DatabaseManagerImpl(
                    Room.databaseBuilder(
                        app ?: throw IllegalStateException("No Application"),
                        MyDragoFusDatabase::class.java,
                        Constants.DATABASE_NAME
                    ).build()
                ).also {
                    databaseManager = it
                }
            }
        }
    }
}