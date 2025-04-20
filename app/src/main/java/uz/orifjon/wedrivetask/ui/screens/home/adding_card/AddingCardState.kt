package uz.orifjon.wedrivetask.ui.screens.home.adding_card

import androidx.compose.runtime.Immutable
import uz.orifjon.wedrivetask.utils.AddingType

@Immutable
data class AddingCardState(
    val cardNumber: String = "",
    val expiredDate: String = "",
    val addingType: AddingType = AddingType.CARD
)