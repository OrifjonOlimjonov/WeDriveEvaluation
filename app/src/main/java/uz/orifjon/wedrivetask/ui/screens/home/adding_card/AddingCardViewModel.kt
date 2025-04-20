package uz.orifjon.wedrivetask.ui.screens.home.adding_card

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uz.orifjon.wedrivetask.data.repository.CardRepository
import uz.orifjon.wedrivetask.domain.models.Card
import uz.orifjon.wedrivetask.ui.core.keyboards.KeypadKey
import uz.orifjon.wedrivetask.utils.AddingType
import uz.orifjon.wedrivetask.utils.BaseViewModel
import uz.orifjon.wedrivetask.utils.extensions.resultOf

class AddingCardViewModel(
    private val cardRepository: CardRepository
) : BaseViewModel<AddingCardState, AddingCardEvent>(AddingCardState()) {

    fun changeInputDataType(type: AddingType) {
        _state.update { it.copy(addingType = type) }
    }


    fun checkInputNotEmpty(): Boolean =
        state.value.cardNumber.length == 16 && state.value.expiredDate.length == 4

    fun onKeypadKey(keypadKey: KeypadKey) {
        var oldValue =
            if (state.value.addingType == AddingType.CARD) state.value.cardNumber else state.value.expiredDate
        val newValue = when (keypadKey) {
            KeypadKey.Delete -> {
                if (oldValue.length == 1) {
                    ""
                }
                oldValue.dropLast(1)
            }

            is KeypadKey.Number -> {
                oldValue.plus(keypadKey.number)
            }

            else -> ""
        }

        if (state.value.addingType == AddingType.CARD) {
            _state.update { it.copy(cardNumber = if (newValue.length <= 16) newValue else state.value.cardNumber) }
        } else {
            _state.update { it.copy(expiredDate = if (newValue.length <= 4) newValue else state.value.expiredDate) }
        }

    }

    fun onClickSave() {
        val cardNumber = state.value.cardNumber
        val expiredDate = state.value.expiredDate
        viewModelScope.launch {
            resultOf {
                cardRepository.addCard(cardNumber, expiredDate)
            }.onSuccess { newCard ->
                _events.send(AddingCardEvent.AfterSuccessfullyAddedNewCard(newCard))
            }.onFailure {
                _events.send(AddingCardEvent.AfterFailedAddedNewCard(it.message.toString()))
            }
        }
    }

}