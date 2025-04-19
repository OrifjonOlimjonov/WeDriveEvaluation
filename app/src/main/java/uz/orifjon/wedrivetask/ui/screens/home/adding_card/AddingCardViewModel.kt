package uz.orifjon.wedrivetask.ui.screens.home.adding_card

import kotlinx.coroutines.flow.update
import uz.orifjon.wedrivetask.ui.core.keyboards.KeypadKey
import uz.orifjon.wedrivetask.utils.BaseViewModel

class AddingCardViewModel(

) : BaseViewModel<AddingCardState, Any>(AddingCardState()) {

    fun changeInputDataType(type: AddingType) {
        _state.update { it.copy(addingType = type) }
    }


    fun onKeypadKey(keypadKey: KeypadKey) {

        var oldValue =
            if (state.value.addingType == AddingType.CARD) state.value.cardNumber else state.value.expiredDate
        val newValue = when (keypadKey) {
            KeypadKey.Delete -> {
                if (oldValue.length == 1) {
                    _state.update {
                        it.copy(

                        )
                    }
                    return
                }
                oldValue.dropLast(1)
            }

            is KeypadKey.Number -> {
                oldValue.plus(keypadKey.number)
            }

            else -> ""
        }

        if (state.value.addingType == AddingType.CARD) {
            _state.update { it.copy(cardNumber = newValue) }
        } else {
            _state.update { it.copy(expiredDate = newValue) }
        }
    }

}