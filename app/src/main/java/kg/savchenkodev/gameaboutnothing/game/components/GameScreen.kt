package kg.savchenkodev.gameaboutnothing.game.components

import android.graphics.Point
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
) {
    Canvas(
        modifier = modifier
            .fillMaxSize()
    ) {
        val rows = 10
        val columns = 5
        drawField(rows, columns)
        drawCharacter(point = Point(2, 2), rows, columns)
    }
}

@Preview
@Composable
private fun GameScreenPreview() {
    GameScreen()
}