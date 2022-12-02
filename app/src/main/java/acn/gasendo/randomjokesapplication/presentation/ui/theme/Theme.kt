package acn.gasendo.randomjokesapplication.presentation.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

private val DarkThemeColors = darkColors(
    primary = Color.White,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightThemeColors = lightColors(
    primary = Color.Black,
    primaryVariant = Purple700,
    secondary = Teal200
)


object ThemeState {
    var isLight by mutableStateOf(true)
}


@Composable
fun RandomJokeApplicationTheme(
    children: @Composable() () -> Unit
) {

    if (ThemeState.isLight) {
        MaterialTheme(colors = LightThemeColors) {
            children()
        }
    } else {
        MaterialTheme(colors = DarkThemeColors) {
            children()
        }

    }
}
