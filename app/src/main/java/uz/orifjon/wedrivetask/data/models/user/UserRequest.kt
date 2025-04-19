package uz.orifjon.wedrivetask.data.models.user

import kotlinx.serialization.Serializable

@Serializable
data class UserRequest(
    val phone: String
)
