import androidx.compose.material.MaterialTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.antonioleiva.tictactoe.ui.App

fun main() = application {
    val state = rememberWindowState(width = 600.dp, height = 800.dp)
    Window(onCloseRequest = ::exitApplication, state = state) {
        MaterialTheme {
            App()
        }
    }
}
