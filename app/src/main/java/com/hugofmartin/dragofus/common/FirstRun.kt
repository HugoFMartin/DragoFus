package com.hugofmartin.dragofus.common

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

object FirstRun {
    private const val FIRST_RUN_KEY = "IS_FIRST_KEY"


    fun isFirstRun(context: Context): Boolean {
        val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val isFirstRun = prefs.getInt(FIRST_RUN_KEY, 0)

        if (isFirstRun == 0) {
            return true
        }
        return false
    }

    fun updateFirstRunKey(context: Context) {
        val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.edit().putInt(FIRST_RUN_KEY, 1).apply()
    }
}