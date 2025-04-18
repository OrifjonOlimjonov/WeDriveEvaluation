package uz.orifjon.wedrivetask

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import uz.orifjon.wedrivetask.navigation.AppHost

@Composable
fun WeDriveComposeApp(navController: NavHostController) {

    AppHost(navController)

}