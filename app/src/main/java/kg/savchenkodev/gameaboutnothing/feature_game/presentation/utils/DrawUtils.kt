package kg.savchenkodev.gameaboutnothing.feature_game.presentation.utils

import android.graphics.Point
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import kg.savchenkodev.gameaboutnothing.R
import kg.savchenkodev.gameaboutnothing.ui.theme.Colors


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
    characterBitmap: ImageBitmap,
    point: Point,
    rows: Int,
    columns: Int
) {
    val cellDensity = minOf(size.width / columns, size.height / rows)

    drawImage(
        image = characterBitmap,
        dstOffset = IntOffset(
            x = (point.x * cellDensity + cellDensity * 0.2).toInt(),
            y = (point.y * cellDensity + cellDensity * 0.2).toInt()
        ),
        dstSize = IntSize((cellDensity * 0.6).toInt(), (cellDensity * 0.6).toInt()),
    )
}

fun DrawScope.drawCoin(
    point: Point,
    rows: Int,
    columns: Int
) {
    drawGameItem(
        point,
        Color.Cyan,
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
        color = Color.Blue,
        size = Size(width, height)
    )
//    for (i in 0..rows) {
//        for (j in 0..columns) {
//            drawRect(
//                color = Colors.iceVariants.random(),
//                topLeft = Offset(i * cellDensity, j * cellDensity),
//                size = Size(cellDensity, cellDensity)
//            )
//        }
//    }

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