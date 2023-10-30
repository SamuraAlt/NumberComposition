package com.altov.vlad.numbercomposition.domain.repository

import com.altov.vlad.numbercomposition.domain.entity.GameSettings
import com.altov.vlad.numbercomposition.domain.entity.Level
import com.altov.vlad.numbercomposition.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSumValue:Int,
        countOfOptions:Int
    ):Question

    fun getGameSettings(level: Level):GameSettings
}