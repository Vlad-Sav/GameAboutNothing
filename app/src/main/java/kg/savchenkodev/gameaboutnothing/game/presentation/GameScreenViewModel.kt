package kg.savchenkodev.gameaboutnothing.game.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.savchenkodev.gameaboutnothing.game_domain.GameDomain
import kg.savchenkodev.gameaboutnothing.game_domain.Level
import kg.savchenkodev.gameaboutnothing.game_domain.MoveDirection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameScreenViewModel @Inject constructor(
    private val game: GameDomain
): ViewModel() {
    val level: MutableStateFlow<Level?> = MutableStateFlow(null)

    init {
        loadLevel()
    }

    private fun loadLevel() {
        viewModelScope.launch(Dispatchers.IO) {
            val levels = game.loadLevel()
            level.value = levels
        }
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