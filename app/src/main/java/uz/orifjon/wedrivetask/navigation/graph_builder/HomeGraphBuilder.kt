package uz.orifjon.wedrivetask.navigation.graph_builder

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import uz.orifjon.wedrivetask.navigation.graph.homeGraph


fun NavGraphBuilder.setHomeGraph(
    navController: NavController
) {
    homeGraph(navController)
}