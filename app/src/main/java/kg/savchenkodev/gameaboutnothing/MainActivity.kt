package kg.savchenkodev.gameaboutnothing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.tooling.preview.Preview
import kg.savchenkodev.gameaboutnothing.game_domain.GameDomain
import kg.savchenkodev.gameaboutnothing.model.GameObject
import kg.savchenkodev.gameaboutnothing.ui.theme.GameAboutNothingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val level = remember {
                mutableStateOf(GameDomain().loadLevel())
            }
            GameAboutNothingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = level.toString(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GameAboutNothingTheme {
        androidx.compose.foundation.Canvas(modifier = Modifier.fillMaxSize()) {
            drawField(4, 3)
        }
    }
}

fun DrawScope.drawField(
    rows: Int,
    columns: Int
) {
    // Calculate the uniform scaling factor to ensure the drawing fits within the Canvas
    val cellDensity = minOf(size.width / columns, size.height / rows)

    // Calculate the total height and width based on the cell density
    val height = cellDensity * rows
    val width = cellDensity * columns

    // Draw the green rectangle background
    drawRect(
        color = Color.Green,
        size = Size(width, height)
    )

    // Draw the vertical lines
    for (i in 0..columns) {
        drawLine(
            color = Color.Black,
            start = Offset(i * cellDensity, 0.0f),
            end = Offset(i * cellDensity, height)
        )
    }

    // Draw the horizontal lines
    for (i in 0..rows) {
        drawLine(
            color = Color.Black,
            start = Offset(0.0f, i * cellDensity),
            end = Offset(width, i * cellDensity)
        )
    }
}

