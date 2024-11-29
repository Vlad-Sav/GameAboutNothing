package kg.savchenkodev.gameaboutnothing.domain.model

import kg.savchenkodev.gameaboutnothing.domain.PointXY
import kg.savchenkodev.gameaboutnothing.domain.Size

sealed class GameObject {
    sealed class GameMoveableObject: GameObject() {
        abstract val coordinates: PointXY
        abstract fun copyWithNewCoordinates(newPointXY: PointXY): GameMoveableObject

        fun adjustPositionToField(field: Field): GameMoveableObject {
            val adjustedX = coordinates.x.coerceIn(0, field.size.width - 1)
            val adjustedY = coordinates.y.coerceIn(0, field.size.height - 1)
            val adjustedCoordinates = PointXY(adjustedX, adjustedY)
            return copyWithNewCoordinates(adjustedCoordinates)
        }

        data class Character(
            override val coordinates: PointXY
        ): GameMoveableObject() {
            override fun copyWithNewCoordinates(newPointXY: PointXY)
                = Character(newPointXY)
        }

        data class Coin(
            override val coordinates: PointXY
        ): GameMoveableObject() {
            override fun copyWithNewCoordinates(newPointXY: PointXY)
                    = Coin(newPointXY)
        }
    }

    data class Field(
        val size: Size
    ): GameObject()
}