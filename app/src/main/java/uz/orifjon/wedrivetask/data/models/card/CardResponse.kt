package uz.orifjon.wedrivetask.data.models.card

import kotlinx.serialization.Serializable

@Serializable
data class CardResponse(
    val expire_date: String,
    val id: Long,
    val number: String,
    val user_id: Int
)