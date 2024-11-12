package kg.savchenkodev.gameaboutnothing.game_domain

import kg.savchenkodev.gameaboutnothing.model.GameObject

class GameDomain {
    private var currentLevel: Level? = null

    fun loadLevel() {
        currentLevel = Level(
            character = GameObject.Character(
                coordinates = Coordinates(x = 2, y = 3)
            ),
            coin = GameObject.Coin(
                coordinates = Coordinates(x = 2, y = 0)
            ),
            field = GameObject.Field(
                coordinates = Coordinates(0, 0),
                size = Size(4, 4)
            )
        )
    }

    fun moveObject(
        gObject: GameObject,
        diff: Coordinates,
        direction: MoveDirection
    ): GameObject {
        if(gObject !is GameObject.Character) return gObject
        val oldCoordinates = gObject.coordinates
        return when(direction) {
            MoveDirection.UP -> {
                gObject.copy(
                    Coordinates(
                        oldCoordinates.x,
                        oldCoordinates.y + diff.y
                    )
                )
            }
            MoveDirection.DOWN -> {
                gObject.copy(
                    Coordinates(
                        oldCoordinates.x,
                        oldCoordinates.y - diff.y
                    )
                )
            }
            MoveDirection.RIGHT -> {
                gObject.copy(
                    Coordinates(
                        oldCoordinates.x + diff.x,
                        oldCoordinates.y
                    )
                )
            }
            MoveDirection.LEFT -> {
                gObject.copy(
                    Coordinates(
                        oldCoordinates.x - diff.x,
                        oldCoordinates.y
                    )
                )
            }
        }
    }
}

enum class MoveDirection {
    UP, DOWN, LEFT, RIGHT
}