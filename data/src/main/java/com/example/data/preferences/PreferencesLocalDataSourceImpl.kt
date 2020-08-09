package com.example.data.preferences

import android.content.Context
import android.content.SharedPreferences

class PreferencesLocalDataSourceImpl(
    private val context: Context
) : PreferencesLocalDataSource {

    override fun getServerUrl(): String =
        getSharedPreferences().getString("key-url", "") ?: ""


    override fun saveServerUrl(url: String) =
        getSharedPreferences().edit().putString("key-url", url).apply()

    private fun getSharedPreferences(): SharedPreferences =
        context.getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE)
}

private const val PREFS_FILE = "prefs"