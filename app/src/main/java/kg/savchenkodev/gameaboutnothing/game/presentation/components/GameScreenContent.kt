package kg.savchenkodev.gameaboutnothing.game.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kg.savchenkodev.gameaboutnothing.game_domain.GameDomain.Companion.DEFAULT_LEVEL
import kg.savchenkodev.gameaboutnothing.game_domain.Level

@Composable
fun GameScreenContent(
    modifier: Modifier = Modifier,
    level: State<Level?> = mutableStateOf(DEFAULT_LEVEL),
    onUp: () -> Unit = {},
    onLeft: () -> Unit = {},
    onRight: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        GameField(
            modifier = Modifier
                .fillMaxHeight(0.9f)
                .padding(16.dp),
            level = level.value ?: DEFAULT_LEVEL
        )

        ButtonPanel(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth(),
            onUp = onUp,
            onLeft = onLeft,
            onRight = onRight
        )
    }
}