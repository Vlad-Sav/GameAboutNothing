package kg.savchenkodev.gameaboutnothing.model

import kg.savchenkodev.gameaboutnothing.game_domain.Coordinates
import kg.savchenkodev.gameaboutnothing.game_domain.Size

sealed class GameObject {
    abstract val coordinates: Coordinates
    data class Character(
        override val coordinates: Coordinates
    ): GameObject()

    data class Coin(
        override val coordinates: Coordinates
    ): GameObject()

    data class Field(
        override val coordinates: Coordinates,
        val size: Size
    ): GameObject()
}