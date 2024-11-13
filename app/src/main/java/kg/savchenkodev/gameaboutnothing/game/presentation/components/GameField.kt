package kg.savchenkodev.gameaboutnothing.game.presentation.components

import android.graphics.Point
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kg.savchenkodev.gameaboutnothing.game.presentation.utils.drawCharacter
import kg.savchenkodev.gameaboutnothing.game.presentation.utils.drawField
import kg.savchenkodev.gameaboutnothing.game_domain.GameDomain.Companion.DEFAULT_LEVEL
import kg.savchenkodev.gameaboutnothing.game_domain.Level

@Composable
fun GameField(
    modifier: Modifier = Modifier,
    level: Level = DEFAULT_LEVEL
) {
    Canvas(
        modifier = modifier
            .fillMaxSize()
    ) {
        val rows = level.field.size.height
        val columns = level.field.size.width
        drawField(rows, columns)
        drawCharacter(
            point = Point(
                level.character.coordinates.x,
                level.character.coordinates.y
            ),
            rows,
            columns
        )
    }
}

@Preview
@Composable
private fun GameFieldPreview() {
    GameField()
}