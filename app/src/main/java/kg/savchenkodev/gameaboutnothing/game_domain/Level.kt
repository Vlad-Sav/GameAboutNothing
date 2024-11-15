package kg.savchenkodev.gameaboutnothing.game_domain

import kg.savchenkodev.gameaboutnothing.model.GameObject

data class Level(
    val character: GameObject.GameMoveableObject.Character,
    val coin: GameObject.GameMoveableObject.Coin,
    val field: GameObject.Field,
    val gameStatus: GameState
)

enum class MoveDirection {
    UP, DOWN, LEFT, RIGHT
}