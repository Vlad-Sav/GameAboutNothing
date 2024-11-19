package kg.savchenkodev.gameaboutnothing.feature_game.presentation.components

import android.graphics.Point
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import kg.savchenkodev.gameaboutnothing.R
import kg.savchenkodev.gameaboutnothing.feature_game.presentation.utils.drawField
import kg.savchenkodev.gameaboutnothing.domain.GameDomain.Companion.DEFAULT_LEVEL
import kg.savchenkodev.gameaboutnothing.domain.Level
import kg.savchenkodev.gameaboutnothing.feature_game.presentation.utils.drawCharacter
import kg.savchenkodev.gameaboutnothing.feature_game.presentation.utils.drawCoin

@Composable
fun GameField(
    modifier: Modifier = Modifier,
    level: Level = DEFAULT_LEVEL
) {
    val character = ImageBitmap.imageResource(R.drawable.stephen)
    val (rows, columns) = remember(level.field.size.height, level.field.size.width) {
        level.field.size.height to level.field.size.width
    }

    Canvas(
        modifier = modifier
            .fillMaxSize()
    ) {

        drawField(rows, columns)
        drawCoin(
            point = Point(
                level.coin.coordinates.x,
                level.coin.coordinates.y
            ),
            rows,
            columns
        )
        drawCharacter(
            characterBitmap = character,
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