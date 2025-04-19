package uz.orifjon.wedrivetask.data.models.wallet

import kotlinx.serialization.Serializable

@Serializable
data class WalletResponse(
    val active_card_id: Int,
    val active_method: String,
    val balance: Long,
    val id: Int,
    val phone: String
)