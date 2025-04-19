package uz.orifjon.wedrivetask.data.repository

import uz.orifjon.wedrivetask.domain.models.Card

interface CardRepository {

    suspend fun addCard(card:Card): Card

}