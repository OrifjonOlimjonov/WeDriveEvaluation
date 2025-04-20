package uz.orifjon.wedrivetask.utils.extensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisallowComposableCalls
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController


fun NavController.navigateAndClearStack(route: Any) {
    navigate(route) {
        popUpTo(0) { inclusive = true }
        launchSingleTop = true
    }
}

inline fun <reified R> NavController.navigateBack(result: R, key: String? = R::class.java.name) {
    previousBackStackEntry?.savedStateHandle?.let {
        it[key ?: ""] = result
    }
    navigateUp()
}

@Composable
inline fun <reified R> NavController.onNavResult(noinline listener: @DisallowComposableCalls (R) -> Unit) {
    if (currentBackStackEntry == null) return
    val currentListener by rememberUpdatedState(listener)
    DisposableEffect(currentBackStackEntry) {
        val observer = object : LifecycleEventObserver {
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                when (event) {
                    Lifecycle.Event.ON_START, Lifecycle.Event.ON_RESUME -> handleResultIfPresent(currentListener)
                    Lifecycle.Event.ON_DESTROY -> currentBackStackEntry!!.lifecycle.removeObserver(this)
                    else -> Unit
                }
            }
        }
        currentBackStackEntry!!.lifecycle.addObserver(observer)
        onDispose {
            currentBackStackEntry!!.lifecycle.removeObserver(observer)
        }
    }
}


inline fun <reified R> NavController.handleResultIfPresent(listener: (R) -> Unit) {
    if (currentBackStackEntry!!.savedStateHandle.contains(R::class.java.name)) {
        listener(
            currentBackStackEntry!!.savedStateHandle.remove<R>(R::class.java.name) as R,
        )
    }
}