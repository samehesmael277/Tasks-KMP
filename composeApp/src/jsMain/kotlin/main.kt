import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import com.sameh.taskskmp.App
import com.sameh.taskskmp.utils.AppModule
import org.jetbrains.skiko.wasm.onWasmReady

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    onWasmReady {
        CanvasBasedWindow("Tasks KMP") {
            App(AppModule())
        }
    }
}
