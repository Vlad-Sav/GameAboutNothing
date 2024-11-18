package kg.savchenkodev.gameaboutnothing.domain.repository

import kg.savchenkodev.gameaboutnothing.domain.Level

interface LevelsRepository {
    suspend fun getLevels(): List<Level>
}