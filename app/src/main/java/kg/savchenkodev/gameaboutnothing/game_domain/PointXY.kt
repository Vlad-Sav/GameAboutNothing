package kg.savchenkodev.gameaboutnothing.game_domain

import kg.savchenkodev.gameaboutnothing.model.GameObject

data class PointXY(
    val x: Int,
    val y: Int
)

data class Size(
    val width: Int,
    val height: Int
)

sealed class GameState {
    data object Loading: GameState()
    data object Default: GameState()
    data object Started: GameState()
}