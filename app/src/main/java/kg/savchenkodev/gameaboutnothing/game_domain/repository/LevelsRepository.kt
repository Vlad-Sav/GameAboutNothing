package kg.savchenkodev.gameaboutnothing.game_domain.repository

import kg.savchenkodev.gameaboutnothing.game_domain.Level

interface LevelsRepository {
    suspend fun getLevels(): List<Level>
}