package kg.savchenkodev.gameaboutnothing.game.components

import android.graphics.Point
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope


fun DrawScope.drawObstacle(
    point: Point,
    rows: Int,
    columns: Int
) {
    drawGameItem(
        point,
        Color.Gray,
        rows,
        columns
    )
}

fun DrawScope.drawCharacter(
    point: Point,
    rows: Int,
    columns: Int
) {
    drawGameItem(
        point,
        Color.Yellow,
        rows,
        columns
    )
}

fun DrawScope.drawGameItem(
    point: Point,
    color: Color,
    rows: Int,
    columns: Int
) {
    val cellDensity = minOf(size.width / columns, size.height / rows)

    drawRect(
        color = color,
        size = Size((cellDensity * 0.6).toFloat(), (cellDensity * 0.6).toFloat()),
        topLeft = Offset(
            x = (point.x * cellDensity + cellDensity * 0.2).toFloat(),
            y = (point.y * cellDensity + cellDensity * 0.2).toFloat()
        )
    )
}

fun DrawScope.drawField(
    rows: Int,
    columns: Int
) {
    val cellDensity = minOf(size.width / columns, size.height / rows)

    val height = cellDensity * rows
    val width = cellDensity * columns

    drawRect(
        color = Color.Green,
        size = Size(width, height)
    )

    for (i in 0..columns) {
        drawLine(
            color = Color.Black,
            start = Offset(i * cellDensity, 0.0f),
            end = Offset(i * cellDensity, height)
        )
    }

    for (i in 0..rows) {
        drawLine(
            color = Color.Black,
            start = Offset(0.0f, i * cellDensity),
            end = Offset(width, i * cellDensity)
        )
    }
}