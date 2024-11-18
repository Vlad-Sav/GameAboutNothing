package kg.savchenkodev.gameaboutnothing.domain

import kg.savchenkodev.gameaboutnothing.domain.model.GameObject

data class Level(
    val character: GameObject.GameMoveableObject.Character,
    val coin: GameObject.GameMoveableObject.Coin,
    val field: GameObject.Field,
    val levelStatus: LevelState
)

enum class MoveDirection {
    UP, DOWN, LEFT, RIGHT
}