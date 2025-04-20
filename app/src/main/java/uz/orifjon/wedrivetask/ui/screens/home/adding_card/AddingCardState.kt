package uz.orifjon.wedrivetask.ui.screens.home.adding_card

import androidx.compose.runtime.Immutable

@Immutable
data class AddingCardState(
    val cardNumber: String = "",
    val expiredDate: String = "",
    val addingType: AddingType = AddingType.CARD
)


enum class AddingType {
    CARD,
    EXPIRED_DATE
}