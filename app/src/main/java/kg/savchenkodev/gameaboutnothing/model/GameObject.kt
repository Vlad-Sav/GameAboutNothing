package kg.savchenkodev.gameaboutnothing.model

import kg.savchenkodev.gameaboutnothing.game_domain.Coordinates
import kg.savchenkodev.gameaboutnothing.game_domain.Size

sealed class GameObject {
    data class Character(
        val coordinates: Coordinates
    ): GameObject()

    data class Coin(
        val coordinates: Coordinates
    ): GameObject()

    data class Field(
        val size: Size
    ): GameObject()
}