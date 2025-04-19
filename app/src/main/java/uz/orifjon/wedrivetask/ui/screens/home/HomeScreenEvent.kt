package uz.orifjon.wedrivetask.ui.screens.home

sealed interface HomeScreenEvent {
    data object AfterSuccessPromoCode : HomeScreenEvent
    data object AfterFailurePromoCode : HomeScreenEvent
}