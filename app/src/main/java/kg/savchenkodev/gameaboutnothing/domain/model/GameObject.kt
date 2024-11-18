package kg.savchenkodev.gameaboutnothing.domain.model

import kg.savchenkodev.gameaboutnothing.domain.PointXY
import kg.savchenkodev.gameaboutnothing.domain.Size

sealed class GameObject {
    sealed class GameMoveableObject: GameObject() {
        abstract val coordinates: PointXY
        abstract fun copyWithNewCoordinates(newPointXY: PointXY): GameMoveableObject

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