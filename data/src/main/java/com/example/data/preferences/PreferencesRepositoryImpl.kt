package com.example.data.preferences

import com.example.domain.preferences.PreferencesRepository

class PreferencesRepositoryImpl(
    private val dataSource: PreferencesLocalDataSource
) : PreferencesRepository {

    override fun getServerUrl(): String =
        dataSource.getServerUrl()

    override fun saveServerUrl(url: String) =
        dataSource.saveServerUrl(url)
}