package com.hugofmartin.dragofus.ui

import android.app.Application
import com.hugofmartin.dragofus.data.database.DatabaseManager

class DragoFusApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initDatabase()
    }

    private fun initDatabase() {
        DatabaseManager.getInstance(this)
    }
}