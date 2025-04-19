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

@Serializable
data object HomeGraph

fun NavGraphBuilder.homeGraph(navController: NavController) {
    navigation<HomeGraph>(startDestination = HomeRoute) {
        composable<HomeRoute> {
            HomeScreen(navController = navController)
        }

        composable<AddingCardRoute>{
            AddingCardScreen(navController = navController)
        }
    }
}