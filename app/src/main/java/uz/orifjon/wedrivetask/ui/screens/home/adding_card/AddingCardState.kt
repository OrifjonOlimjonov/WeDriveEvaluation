package uz.orifjon.wedrivetask.ui.screens.home.adding_card

data class AddingCardState(
    val cardNumber: String = "0000 0000 0000 0000",
    val expiredDate: String = "12/25",
    val addingType: AddingType = AddingType.CARD
)


enum class AddingType {
    CARD,
    EXPIRED_DATE
}