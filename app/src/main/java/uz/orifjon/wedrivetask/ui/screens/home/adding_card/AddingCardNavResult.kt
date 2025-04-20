package uz.orifjon.wedrivetask.ui.screens.home.adding_card

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import uz.orifjon.wedrivetask.domain.models.Card

@Parcelize
data class AddingCardNavResult(
    val card: Card
): Parcelable