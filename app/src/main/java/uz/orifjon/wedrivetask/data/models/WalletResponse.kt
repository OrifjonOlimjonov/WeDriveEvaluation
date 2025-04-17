package uz.orifjon.wedrivetask.data.models



data class WalletResponse(
    val active_card_id: Int,
    val active_method: String,
    val balance: Int,
    val id: Int,
    val phone: String
)