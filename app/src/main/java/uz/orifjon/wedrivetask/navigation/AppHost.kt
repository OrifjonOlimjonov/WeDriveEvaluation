package uz.orifjon.wedrivetask.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import uz.orifjon.wedrivetask.ui.screens.home.graph.HomeGraph
import uz.orifjon.wedrivetask.navigation.graph_builder.setHomeGraph

private const val TRANSITION_ANIMATION_DURATION_IN_MS = 100

@Composable
fun AppHost(
    navController: NavHostController
) {

    NavHost(navController = navController,
       enterTransition = { fadeIn(animationSpec = tween(TRANSITION_ANIMATION_DURATION_IN_MS)) },
        exitTransition = { fadeOut(animationSpec = tween(TRANSITION_ANIMATION_DURATION_IN_MS)) },
        startDestination = HomeGraph) {
        setHomeGraph(navController)
    }

}