import androidx.compose.ui.window.ComposeUIViewController
import com.sameh.taskskmp.App
import com.sameh.taskskmp.utils.AppModule
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App(AppModule()) }
