package uz.orifjon.wedrivetask.ui.screens.splash

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.orifjon.wedrivetask.cache.preferences.UserPreferences
import uz.orifjon.wedrivetask.utils.BaseViewModel

class SplashViewModel(
    private val userPreferences: UserPreferences
) : BaseViewModel<Any, SplashEvent>(Any()) {

    init {
        getUserPreferences()
    }

    private fun getUserPreferences() {

        viewModelScope.launch {
            if (userPreferences.phoneNumber == null) {
                _events.send(SplashEvent.ShouldLogIn)
            } else {
                _events.send(SplashEvent.HasPhoneNumber)
            }
        }

    }

}