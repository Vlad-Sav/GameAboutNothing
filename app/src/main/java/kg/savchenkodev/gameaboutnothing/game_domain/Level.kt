package kg.savchenkodev.gameaboutnothing.game_domain

import kg.savchenkodev.gameaboutnothing.model.GameObject

data class Level(
    val character: GameObject.Character,
    val coin: GameObject.Coin,
    val field: GameObject.Field
)