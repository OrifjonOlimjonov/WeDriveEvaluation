package uz.orifjon.wedrivetask.ui.screens.home.adding_card

import uz.orifjon.wedrivetask.domain.models.Card

sealed interface AddingCardEvent {
    data class AfterSuccessfullyAddedNewCard(val newCard: Card): AddingCardEvent
    data object AfterFailedAddedNewCard: AddingCardEvent
}