package com.altov.vlad.numbercomposition.domain.usecases

import com.altov.vlad.numbercomposition.domain.entity.GameSettings
import com.altov.vlad.numbercomposition.domain.entity.Level
import com.altov.vlad.numbercomposition.domain.repository.GameRepository

class GetGameSettingsUseCase(private val repository: GameRepository) {

    operator fun invoke(level: Level):GameSettings{
        return repository.getGameSettings(level)
    }
}