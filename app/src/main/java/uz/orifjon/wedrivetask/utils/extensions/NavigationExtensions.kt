package uz.orifjon.wedrivetask.utils.extensions

import androidx.navigation.NavController


fun NavController.navigateAndClearStack(route: Any) {
    navigate(route) {
        popUpTo(0) { inclusive = true }
        launchSingleTop = true
    }
}
