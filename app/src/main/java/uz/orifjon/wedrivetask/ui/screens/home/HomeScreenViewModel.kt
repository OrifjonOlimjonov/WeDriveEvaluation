package uz.orifjon.wedrivetask.ui.screens.home

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import uz.orifjon.wedrivetask.data.repository.PromoCodeRepository
import uz.orifjon.wedrivetask.utils.BaseViewModel

class HomeScreenViewModel(
    private val promoCodeRepository:PromoCodeRepository
) : BaseViewModel<HomeScreenState, Any>(HomeScreenState()) {

    fun onBottomSheet() {
        _state.update { it.copy(promoCodeBottomSheetState = !state.value.promoCodeBottomSheetState) }
    }



    fun addPromoCode(code: String){
        viewModelScope.launch {
            promoCodeRepository.addPromoCode(code)
        }
    }

}