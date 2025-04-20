package uz.orifjon.wedrivetask.ui.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel
import uz.orifjon.wedrivetask.R
import uz.orifjon.wedrivetask.ui.core.FillEmptySpace
import uz.orifjon.wedrivetask.ui.screens.home.HomeRoute
import uz.orifjon.wedrivetask.ui.screens.login.LoginRoute
import uz.orifjon.wedrivetask.utils.extensions.navigateAndClearStack


@Serializable
data object SplashRoute

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel = koinViewModel()
) {

    LaunchedEffect(Unit) {
        delay(2000)
        viewModel.events.collect { event ->
            when (event) {
                SplashEvent.HasPhoneNumber -> {
                    navController.navigateAndClearStack(HomeRoute)
                }

                SplashEvent.ShouldLogIn -> {
                    navController.navigateAndClearStack(LoginRoute)
                }
            }
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Black),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FillEmptySpace()
        Text(stringResource(R.string.we_drive), color = White)
        FillEmptySpace()
    }


}