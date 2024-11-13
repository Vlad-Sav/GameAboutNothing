package kg.savchenkodev.gameaboutnothing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import kg.savchenkodev.gameaboutnothing.game.presentation.GameScreen
import kg.savchenkodev.gameaboutnothing.game_domain.GameDomain
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
                    GameScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
