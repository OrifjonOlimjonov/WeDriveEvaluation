package uz.orifjon.wedrivetask.ui.screens.login

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uz.orifjon.wedrivetask.data.repository.UserRepository
import uz.orifjon.wedrivetask.utils.BaseViewModel
import uz.orifjon.wedrivetask.utils.extensions.resultOf

class LoginViewModel(
    private val userRepository: UserRepository
) : BaseViewModel<LoginState, LoginEvent>(LoginState()) {

    fun changePhoneNumber(phoneNumber: String) {
        _state.update { it.copy(phoneNumber = phoneNumber) }
    }

    fun login() {
        viewModelScope.launch {
            resultOf {
                userRepository.login(state.value.phoneNumber)
            }.onSuccess {
                _events.send(LoginEvent.AfterLogIn)
            }.onFailure {
                _events.send(LoginEvent.LoginError(it.message))
            }
        }
    }


}