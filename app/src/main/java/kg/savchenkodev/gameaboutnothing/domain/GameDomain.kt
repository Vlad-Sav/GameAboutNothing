package kg.savchenkodev.gameaboutnothing.domain

import android.util.Log
import kg.savchenkodev.gameaboutnothing.domain.repository.LevelsRepository
import kg.savchenkodev.gameaboutnothing.domain.model.GameObject
import javax.inject.Inject


class GameDomain @Inject constructor(
    private val levelsRepository: LevelsRepository
) {
    private var currentLevel: Level? = null
    private var currentLevelIndex: Int = 0

    suspend fun loadLevel(): Level? {
        val levels = levelsRepository.getLevels()
        currentLevel = levels.getOrNull(currentLevelIndex)
        return currentLevel
    }

    fun moveCharacter(direction: MoveDirection): Level? {
        val level = currentLevel ?: return null

        val character = level.character
        val newCoordinates = calculateNewCoordinates(character.coordinates, direction)

        val validCoordinates = validateCoordinates(newCoordinates, level.field)

        val updatedCharacter = character.copyWithNewCoordinates(validCoordinates)

        val newLevelStatus = if (newCoordinates == level.coin.coordinates) {
            LevelState.Finished
        } else {
            LevelState.Started
        }

        currentLevel = level.copy(character = updatedCharacter, levelStatus = newLevelStatus)
        return currentLevel
    }

    private fun validateCoordinates(coordinates: PointXY, field: GameObject.Field): PointXY {
        val adjustedX = coordinates.x.coerceIn(0, field.size.width - 1)
        val adjustedY = coordinates.y.coerceIn(0, field.size.height - 1)
        return PointXY(adjustedX, adjustedY)
    }

    private fun moveObject(
        gObject: GameObject,
        diff: PointXY,
        direction: MoveDirection
    ): GameObject {
        if (gObject !is GameObject.GameMoveableObject) return gObject
        val oldCoordinates = gObject.coordinates
        val newPointXY = when (direction) {
            MoveDirection.UP -> PointXY(oldCoordinates.x, oldCoordinates.y - diff.y)
            MoveDirection.DOWN -> PointXY(oldCoordinates.x, oldCoordinates.y + diff.y)
            MoveDirection.RIGHT -> PointXY(oldCoordinates.x + diff.x, oldCoordinates.y)
            MoveDirection.LEFT -> PointXY(oldCoordinates.x - diff.x, oldCoordinates.y)
        }

        return gObject.copyWithNewCoordinates(newPointXY)
    }

    private fun calculateNewCoordinates(
        currentCoordinates: PointXY,
        direction: MoveDirection
    ): PointXY {
        return when (direction) {
            MoveDirection.UP -> currentCoordinates.copy(y = currentCoordinates.y - 1)
            MoveDirection.DOWN -> currentCoordinates.copy(y = currentCoordinates.y + 1)
            MoveDirection.LEFT -> currentCoordinates.copy(x = currentCoordinates.x - 1)
            MoveDirection.RIGHT -> currentCoordinates.copy(x = currentCoordinates.x + 1)
        }
    }

    private fun isOutOfField(coordinates: PointXY, field: GameObject.Field): Boolean {
        return coordinates.x !in 0 until field.size.width || coordinates.y !in 0 until field.size.height
    }

    private fun isObstacle(coordinates: PointXY, level: Level): Boolean {
        // Placeholder for obstacle validation logic
        // Add your specific obstacle validation if needed
        return false
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
            ),
            levelStatus = LevelState.Started
        )
    }
}