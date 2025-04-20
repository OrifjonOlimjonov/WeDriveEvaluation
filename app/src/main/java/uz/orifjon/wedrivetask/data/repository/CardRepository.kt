package uz.orifjon.wedrivetask.data.repository

import uz.orifjon.wedrivetask.domain.models.Card

interface CardRepository {

    suspend fun addCard(cardNumber:String,expiredDate: String): Card

}