package uz.orifjon.wedrivetask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import uz.orifjon.wedrivetask.ui.theme.WeDriveTaskTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeDriveTaskTheme {
                Surface {
                    navController = rememberNavController()
                    WeDriveComposeApp(navController)
                }
            }
        }
    }
}
