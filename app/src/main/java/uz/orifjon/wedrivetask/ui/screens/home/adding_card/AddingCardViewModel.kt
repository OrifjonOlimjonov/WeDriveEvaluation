package uz.orifjon.wedrivetask.ui.screens.home.adding_card

import kotlinx.coroutines.flow.update
import uz.orifjon.wedrivetask.ui.core.keyboards.KeypadKey
import uz.orifjon.wedrivetask.utils.BaseViewModel

class AddingCardViewModel(

) : BaseViewModel<AddingCardState, Any>(AddingCardState()) {

    fun changeExpiredDateValue(expiredDate: String) =
        _state.update { it.copy(expiredDate = expiredDate) }

    fun changeCardNumberValue(cardNumber: String) =
        _state.update { it.copy(cardNumber = cardNumber) }



    fun onKeypadKey(keypadKey: KeypadKey){



    }
}