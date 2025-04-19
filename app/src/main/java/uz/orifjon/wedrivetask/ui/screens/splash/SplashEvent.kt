package uz.orifjon.wedrivetask.ui.screens.splash

sealed interface SplashEvent {
    data object HasPhoneNumber : SplashEvent
    data object ShouldLogIn : SplashEvent
}