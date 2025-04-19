package uz.orifjon.wedrivetask.data.models.promo

import kotlinx.serialization.Serializable

@Serializable
data class PromoRequest(
    val code: String
)