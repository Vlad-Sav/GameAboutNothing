package kg.savchenkodev.gameaboutnothing.game.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import kg.savchenkodev.gameaboutnothing.game.presentation.components.GameScreenContent

@Composable
fun GameScreen(
    modifier: Modifier = Modifier
) {
    val viewModel = hiltViewModel<GameScreenViewModel>()

    GameScreenContent(
        modifier = modifier,
        level = viewModel.level.collectAsStateWithLifecycle(),
        onUp = {
            viewModel.actionUp()
        },
        onLeft = {
            viewModel.actionLeft()
        },
        onRight = {
            viewModel.actionRight()
        }
    )
}