package uz.orifjon.wedrivetask.data.models.card

import kotlinx.serialization.Serializable

@Serializable
data class CardRequest(
    val number: String,
    val expire_date: String
)
