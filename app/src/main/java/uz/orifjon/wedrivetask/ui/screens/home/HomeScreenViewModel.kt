package uz.orifjon.wedrivetask.ui.screens.home

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uz.orifjon.wedrivetask.data.repository.CardRepository
import uz.orifjon.wedrivetask.data.repository.PromoCodeRepository
import uz.orifjon.wedrivetask.data.repository.WalletRepository
import uz.orifjon.wedrivetask.domain.models.Card
import uz.orifjon.wedrivetask.utils.BaseViewModel
import uz.orifjon.wedrivetask.utils.extensions.resultOf

class HomeScreenViewModel(
    private val promoCodeRepository: PromoCodeRepository,
    private val walletRepository: WalletRepository,
    private val cardRepository: CardRepository,
) : BaseViewModel<HomeScreenState, HomeScreenEvent>(HomeScreenState()) {



    init {
        getWallet()
        updateCardList()
    }

    private fun getWallet() {
        viewModelScope.launch {
            resultOf {
                walletRepository.getWallet()
            }.onSuccess { wallet ->
                _state.update { it.copy(wallet = wallet) }
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

}