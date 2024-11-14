package kg.savchenkodev.gameaboutnothing.game.presentation

import androidx.lifecycle.ViewModel
import kg.savchenkodev.gameaboutnothing.game_domain.GameDomain
import kg.savchenkodev.gameaboutnothing.game_domain.Level
import kg.savchenkodev.gameaboutnothing.game_domain.MoveDirection
import kotlinx.coroutines.flow.MutableStateFlow

class GameScreenViewModel: ViewModel() {
    private var game: GameDomain = GameDomain()
    val level: MutableStateFlow<Level?> = MutableStateFlow(null)

    init {
        loadLevel()
    }

    fun loadLevel() {
        level.value = game.loadLevel()
    }

    fun actionUp() {
        level.value = game.moveCharacter(MoveDirection.UP)
    }

    fun actionLeft() {
        level.value = game.moveCharacter(MoveDirection.LEFT)
    }

    fun actionRight() {
        level.value = game.moveCharacter(MoveDirection.RIGHT)
    }
}