package uz.orifjon.wedrivetask.ui.screens.home

sealed interface HomeScreenEvent {
    data object AfterSuccessPromoCode : HomeScreenEvent
    data object AfterFailurePromoCode : HomeScreenEvent
    data object AfterChangePaymentMethodFailure : HomeScreenEvent
    data object AfterChangePaymentMethodSuccess : HomeScreenEvent
}