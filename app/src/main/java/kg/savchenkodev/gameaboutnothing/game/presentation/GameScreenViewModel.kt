package kg.savchenkodev.gameaboutnothing.game.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.savchenkodev.gameaboutnothing.game_domain.GameDomain
import kg.savchenkodev.gameaboutnothing.game_domain.Level
import kotlinx.coroutines.flow.MutableStateFlow

@HiltViewModel
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
        level.value = game.actionUp()
    }

    fun actionLeft() {
        level.value = game.actionLeft()
    }

    fun actionRight() {
        level.value = game.actionRight()
    }
}