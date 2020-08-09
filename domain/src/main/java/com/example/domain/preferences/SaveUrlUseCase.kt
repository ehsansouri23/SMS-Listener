package com.example.domain.preferences

import com.example.domain.BaseUseCase

class SaveUrlUseCase(
    private val repository: PreferencesRepository
) : BaseUseCase<String, Unit>() {

    override suspend fun run(input: String) =
        repository.saveServerUrl(input)

}