package uz.orifjon.wedrivetask.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kotlinx.serialization.Serializable
import uz.orifjon.wedrivetask.ui.screens.home.HomeRoute
import uz.orifjon.wedrivetask.ui.screens.home.HomeScreen
import uz.orifjon.wedrivetask.ui.screens.home.adding_card.AddingCardRoute
import uz.orifjon.wedrivetask.ui.screens.home.adding_card.AddingCardScreen
import uz.orifjon.wedrivetask.ui.screens.login.LoginRoute
import uz.orifjon.wedrivetask.ui.screens.login.LoginScreen
import uz.orifjon.wedrivetask.ui.screens.splash.SplashRoute
import uz.orifjon.wedrivetask.ui.screens.splash.SplashScreen

@Serializable
data object HomeGraph

fun NavGraphBuilder.homeGraph(navController: NavController) {
    navigation<HomeGraph>(startDestination = SplashRoute) {

        composable<HomeRoute> {
            HomeScreen(navController = navController)
        }

        composable<AddingCardRoute> {
            AddingCardScreen(navController = navController)
        }

        composable<LoginRoute> {
            LoginScreen(navController = navController)
        }

        composable<SplashRoute> {
            SplashScreen(navController)
        }

    }
}