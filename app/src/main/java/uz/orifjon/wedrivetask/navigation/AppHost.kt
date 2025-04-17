package uz.orifjon.wedrivetask.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import uz.orifjon.wedrivetask.ui.screens.home.graph.HomeGraph
import uz.orifjon.wedrivetask.navigation.graph_builder.setHomeGraph

@Composable
fun AppHost(
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = HomeGraph) {
        setHomeGraph(navController)
    }

}