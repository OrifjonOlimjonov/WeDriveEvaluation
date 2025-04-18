package uz.orifjon.wedrivetask.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Wallet(
    val activeCardId: Int,
    val activeMethod: String,
    val balance: Long,
    val id: Int,
    val phone: String
)
