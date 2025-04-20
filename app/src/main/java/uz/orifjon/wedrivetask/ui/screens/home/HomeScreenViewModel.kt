package uz.orifjon.wedrivetask.ui.screens.home

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uz.orifjon.wedrivetask.data.repository.CardRepository
import uz.orifjon.wedrivetask.data.repository.PromoCodeRepository
import uz.orifjon.wedrivetask.data.repository.WalletRepository
import uz.orifjon.wedrivetask.domain.mappers.PaymentType
import uz.orifjon.wedrivetask.domain.models.Card
import uz.orifjon.wedrivetask.utils.BaseViewModel
import uz.orifjon.wedrivetask.utils.extensions.resultOf

class HomeScreenViewModel(
    private val promoCodeRepository: PromoCodeRepository,
    private val walletRepository: WalletRepository,
    private val cardRepository: CardRepository,
) : BaseViewModel<HomeScreenState, HomeScreenEvent>(HomeScreenState()) {

    var job: Job? = null

    init {
        getWallet()
        updateCardList()
    }

    private fun getWallet() {
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            resultOf {
                walletRepository.getWallet()
            }.onSuccess { wallet ->
                _state.update {
                    it.copy(
                        wallet = wallet,
                        selectedPaymentType = wallet.activeMethod,
                        selectedCardId = wallet.activeCardId,
                        isLoading = false
                    )
                }
            }.onFailure {

            }
        }
    }

    fun onBottomSheet() {
        _state.update { it.copy(promoCodeBottomSheetState = !state.value.promoCodeBottomSheetState) }
    }


    fun addPromoCode(code: String) {
        viewModelScope.launch {
            resultOf {
                promoCodeRepository.addPromoCode(code)
            }.onSuccess {
                onBottomSheet()
                _events.send(HomeScreenEvent.AfterSuccessPromoCode)
            }.onFailure {
                onBottomSheet()
                _events.send(HomeScreenEvent.AfterFailurePromoCode)
            }
        }
    }

    fun updateCardList() {
        viewModelScope.launch {
            resultOf {
                cardRepository.getCards()
            }.onSuccess { cards ->
                _state.update { it.copy(cards = cards) }
            }.onFailure {

            }
        }
    }

    fun isCash(): Boolean = state.value.selectedPaymentType == PaymentType.cash

    fun isChecked(card: Card): Boolean =
        state.value.selectedPaymentType == PaymentType.card && state.value.selectedCardId == card.cardId

    fun changePaymentType(cardId: Long?, paymentType: PaymentType) {
        job?.cancel()
        job = viewModelScope.launch {
            delay(500)
            resultOf {
                walletRepository.changePaymentType(
                    activeMethod = paymentType,
                    activeCardId = cardId
                )
            }.onSuccess {
                _state.update {
                    it.copy(
                        selectedCardId = cardId,
                        selectedPaymentType = paymentType
                    )
                }
                _events.send(HomeScreenEvent.AfterChangePaymentMethodSuccess)
            }.onFailure {
                _events.send(HomeScreenEvent.AfterChangePaymentMethodFailure)
            }
        }
    }


}