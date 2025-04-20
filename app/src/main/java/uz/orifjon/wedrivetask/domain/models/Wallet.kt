package uz.orifjon.wedrivetask.domain.models

import kotlinx.serialization.Serializable
import uz.orifjon.wedrivetask.domain.mappers.PaymentType

@Serializable
data class Wallet(
    val activeCardId: Long?,
    val activeMethod: PaymentType,
    val balance: Double,
    val id: Int,
    val phone: String
)
