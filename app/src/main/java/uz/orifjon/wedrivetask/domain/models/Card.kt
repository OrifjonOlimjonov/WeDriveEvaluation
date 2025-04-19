package uz.orifjon.wedrivetask.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Card(
    val cardNumber: String,
    val expiredDate: String
)
