package kg.savchenkodev.gameaboutnothing.game_domain

import kg.savchenkodev.gameaboutnothing.model.GameObject

class GameDomain {
    private var currentLevel: Level? = null

    suspend fun loadLevel() {
        currentLevel = Level(
            character = GameObject.Character(
                coordinates = Coordinates(x = 2, y = 3)
            ),
            coin = GameObject.Coin(
                coordinates = Coordinates(x = 2, y = 0)
            ),
            field = GameObject.Field(
                size = Size(4, 4)
            )
        )
    }
}