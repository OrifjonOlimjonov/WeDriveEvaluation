package uz.orifjon.wedrivetask.data.models.payment_method

import kotlinx.serialization.Serializable

@Serializable
data class PaymentMethodRequest(
    val active_method: String,
    val active_card_id: String? = null
)
