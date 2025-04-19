package uz.orifjon.wedrivetask.ui.screens.login

sealed interface LoginEvent {
    data object AfterLogIn : LoginEvent
    data class LoginError(val errorMessage: String?) : LoginEvent
}
