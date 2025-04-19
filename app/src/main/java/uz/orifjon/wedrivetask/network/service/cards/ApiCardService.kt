package uz.orifjon.wedrivetask.network.service.cards

import uz.orifjon.wedrivetask.data.models.card.CardRequest
import uz.orifjon.wedrivetask.data.models.card.CardResponse

interface ApiCardService {

    suspend fun getCards(): List<CardResponse>

    suspend fun addCard(cardRequest: CardRequest)

}