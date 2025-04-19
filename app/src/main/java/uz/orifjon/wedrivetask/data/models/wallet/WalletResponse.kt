package uz.orifjon.wedrivetask.data.models.wallet

import kotlinx.serialization.Serializable
import uz.orifjon.wedrivetask.domain.mappers.PaymentType

@Serializable
data class WalletResponse(
    val active_card_id: Int,
    val active_method: PaymentType,
    val balance: Long,
    val id: Int,
    val phone: String
)