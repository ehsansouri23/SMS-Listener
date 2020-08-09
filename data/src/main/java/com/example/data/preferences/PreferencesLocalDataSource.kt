package com.example.data.preferences

interface PreferencesLocalDataSource {
    fun getServerUrl(): String

    fun saveServerUrl(url: String)
}