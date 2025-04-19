package uz.orifjon.wedrivetask.ui.screens.home.adding_card

data class AddingCardState(
    val cardNumber: String = "",
    val expiredDate: String = "",
    val addingType: AddingType = AddingType.EXPIRED_DATE
)


enum class AddingType {
    CARD,
    EXPIRED_DATE
}