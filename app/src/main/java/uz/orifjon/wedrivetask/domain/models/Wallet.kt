package uz.orifjon.wedrivetask.domain.models

import kotlinx.serialization.Serializable
import uz.orifjon.wedrivetask.domain.mappers.PaymentType

@Serializable
data class Wallet(
    val activeCardId: Int,
    val activeMethod: PaymentType,
    val balance: Long,
    val id: Int,
    val phone: String
)
