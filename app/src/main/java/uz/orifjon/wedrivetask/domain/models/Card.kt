package uz.orifjon.wedrivetask.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Card(
    val cardNumber: String,
    val expiredDate: String
) : Parcelable
