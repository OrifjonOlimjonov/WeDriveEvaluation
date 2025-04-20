package uz.orifjon.wedrivetask.data.models.wallet

import kotlinx.serialization.Serializable
import uz.orifjon.wedrivetask.domain.mappers.PaymentType

@Serializable
data class WalletResponse(
    val active_card_id: Long?,
    val active_method: PaymentType,
    val balance: Double,
    val id: Int,
    val phone: String
)