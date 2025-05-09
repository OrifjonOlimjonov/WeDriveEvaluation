package uz.orifjon.wedrivetask.ui.screens.home

import androidx.compose.runtime.Immutable
import uz.orifjon.wedrivetask.domain.models.Card
import uz.orifjon.wedrivetask.domain.models.Wallet
import uz.orifjon.wedrivetask.utils.PaymentType

@Immutable
data class HomeScreenState(
    val isLoading: Boolean = false,
    val promoCodeBottomSheetState: Boolean = false,
    val wallet: Wallet? = null,
    val cards:List<Card> = emptyList(),
    val selectedCardId: Long? = null,
    val selectedPaymentType: PaymentType = PaymentType.card
)
