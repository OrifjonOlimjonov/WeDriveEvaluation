package uz.orifjon.wedrivetask.utils

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow


abstract class BaseViewModel<STATE, EVENT>(
    initialState: STATE,
) : ViewModel() {


    protected val _state = MutableStateFlow(initialState)
    val state = _state.asStateFlow()

    protected val _events = Channel<EVENT>(Channel.BUFFERED)
    val events = _events.receiveAsFlow()

}