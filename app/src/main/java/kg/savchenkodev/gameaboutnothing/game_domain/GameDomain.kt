package kg.savchenkodev.gameaboutnothing.game_domain

import kg.savchenkodev.gameaboutnothing.model.GameObject

class GameDomain {
    private var currentLevel: Level? = null

    fun loadLevel() {
        currentLevel = DEFAULT_LEVEL
    }

    fun moveObject(
        gObject: GameObject,
        diff: Coordinates,
        direction: MoveDirection
    ): GameObject {
        if(gObject !is GameObject.GameMoveableObject) return gObject
        val oldCoordinates = gObject.coordinates
        return when(direction) {
            MoveDirection.UP -> {
                gObject.copyWithNewCoordinates(
                    Coordinates(
                        oldCoordinates.x,
                        oldCoordinates.y + diff.y
                    )
                )
            }
            MoveDirection.DOWN -> {
                gObject.copyWithNewCoordinates(
                    Coordinates(
                        oldCoordinates.x,
                        oldCoordinates.y - diff.y
                    )
                )
            }
            MoveDirection.RIGHT -> {
                gObject.copyWithNewCoordinates(
                    Coordinates(
                        oldCoordinates.x + diff.x,
                        oldCoordinates.y
                    )
                )
            }
            MoveDirection.LEFT -> {
                gObject.copyWithNewCoordinates(
                    Coordinates(
                        oldCoordinates.x - diff.x,
                        oldCoordinates.y
                    )
                )
            }
        }
    }

    companion object {
        val DEFAULT_LEVEL = Level(
            character = GameObject.GameMoveableObject.Character(
                coordinates = Coordinates(x = 2, y = 3)
            ),
            coin = GameObject.GameMoveableObject.Coin(
                coordinates = Coordinates(x = 2, y = 0)
            ),
            field = GameObject.Field(
                size = Size(4, 4)
            )
        )
    }
}

enum class MoveDirection {
    UP, DOWN, LEFT, RIGHT
}