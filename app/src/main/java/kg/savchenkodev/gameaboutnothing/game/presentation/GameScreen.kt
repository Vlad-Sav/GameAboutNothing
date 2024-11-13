package kg.savchenkodev.gameaboutnothing.game.presentation

import android.graphics.Point
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kg.savchenkodev.gameaboutnothing.game.presentation.components.ButtonPanel
import kg.savchenkodev.gameaboutnothing.game.presentation.components.GameField
import kg.savchenkodev.gameaboutnothing.game.presentation.utils.drawCharacter
import kg.savchenkodev.gameaboutnothing.game.presentation.utils.drawField
import kg.savchenkodev.gameaboutnothing.game_domain.GameDomain.Companion.DEFAULT_LEVEL
import kg.savchenkodev.gameaboutnothing.game_domain.Level

@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    level: Level = DEFAULT_LEVEL
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
            level = level
        )
        ButtonPanel(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun GameScreenPreview() {
    GameScreen()
}