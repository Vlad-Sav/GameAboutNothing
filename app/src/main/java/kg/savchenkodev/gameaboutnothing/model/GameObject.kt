package kg.savchenkodev.gameaboutnothing.model

import kg.savchenkodev.gameaboutnothing.game_domain.Coordinates
import kg.savchenkodev.gameaboutnothing.game_domain.Size

sealed class GameObject {
    sealed class GameMoveableObject: GameObject() {
        abstract val coordinates: Coordinates
        abstract fun copyWithNewCoordinates(newCoordinates: Coordinates): GameMoveableObject

        data class Character(
            override val coordinates: Coordinates
        ): GameMoveableObject() {
            override fun copyWithNewCoordinates(newCoordinates: Coordinates)
                = Character(newCoordinates)
        }

        data class Coin(
            override val coordinates: Coordinates
        ): GameMoveableObject() {
            override fun copyWithNewCoordinates(newCoordinates: Coordinates)
                    = Character(newCoordinates)
        }
    }

    data class Field(
        val size: Size
    ): GameObject()
}