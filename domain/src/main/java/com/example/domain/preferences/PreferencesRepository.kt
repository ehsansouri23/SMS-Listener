package com.example.domain.preferences

interface PreferencesRepository {

    fun getServerUrl(): String

    fun saveServerUrl(url: String)
}