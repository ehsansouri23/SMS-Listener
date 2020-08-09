package com.example.domain.preferences

import com.example.domain.BaseUseCase

class GetUrlUseCase(
    private val repository: PreferencesRepository
) : BaseUseCase<Unit, String>() {

    override suspend fun run(input: Unit): String =
        repository.getServerUrl()
}