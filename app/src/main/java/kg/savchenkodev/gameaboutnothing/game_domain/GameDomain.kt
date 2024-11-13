package kg.savchenkodev.gameaboutnothing.game_domain

import kg.savchenkodev.gameaboutnothing.model.GameObject

class GameDomain {
    private var currentLevel: Level? = null

    fun loadLevel(): Level {
        val level = DEFAULT_LEVEL
        currentLevel = level
        return level
    }

    fun actionUp(): Level? {
        val level = currentLevel ?: return null
        val newObj = moveObject(
            level.character,
            PointXY(0, 1),
            MoveDirection.UP
        ) as? GameObject.GameMoveableObject.Character ?: return null
        return level.copy(character = newObj)
    }

    fun actionLeft(): Level? {
        val level = currentLevel ?: return null
        val newObj = moveObject(
            level.character,
            PointXY(1, 0),
            MoveDirection.LEFT
        ) as? GameObject.GameMoveableObject.Character ?: return null
        return level.copy(character = newObj)
    }

    fun actionRight(): Level? {
        val level = currentLevel ?: return null
        val newObj = moveObject(
            level.character,
            PointXY(1, 0),
            MoveDirection.RIGHT
        ) as? GameObject.GameMoveableObject.Character ?: return null
        return level.copy(character = newObj)
    }

    private fun moveObject(
        gObject: GameObject,
        diff: PointXY,
        direction: MoveDirection
    ): GameObject {
        if (gObject !is GameObject.GameMoveableObject) return gObject
        val oldCoordinates = gObject.coordinates
        val newPointXY = when (direction) {
            MoveDirection.UP -> PointXY(oldCoordinates.x, oldCoordinates.y + diff.y)
            MoveDirection.DOWN -> PointXY(oldCoordinates.x, oldCoordinates.y - diff.y)
            MoveDirection.RIGHT -> PointXY(oldCoordinates.x + diff.x, oldCoordinates.y)
            MoveDirection.LEFT -> PointXY(oldCoordinates.x - diff.x, oldCoordinates.y)
        }

        return gObject.copyWithNewCoordinates(newPointXY)
    }

    companion object {
        val DEFAULT_LEVEL = Level(
            character = GameObject.GameMoveableObject.Character(
                coordinates = PointXY(x = 2, y = 3)
            ),
            coin = GameObject.GameMoveableObject.Coin(
                coordinates = PointXY(x = 2, y = 0)
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