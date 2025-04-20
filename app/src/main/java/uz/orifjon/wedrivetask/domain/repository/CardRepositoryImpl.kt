package uz.orifjon.wedrivetask.domain.repository

import uz.orifjon.wedrivetask.data.models.card.CardRequest
import uz.orifjon.wedrivetask.data.repository.CardRepository
import uz.orifjon.wedrivetask.domain.mappers.toDomain
import uz.orifjon.wedrivetask.domain.models.Card
import uz.orifjon.wedrivetask.network.service.cards.ApiCardService

class CardRepositoryImpl(
    private val apiCardService: ApiCardService
) : CardRepository {

    override suspend fun addCard(
        cardNumber: String,
        expiredDate: String
    ): Card {
        val expiredDate = expiredDate.chunked(2).joinToString("/")

        val cardResponse = apiCardService.addCard(CardRequest(cardNumber, expiredDate))

        return cardResponse.toDomain()
    }

    override suspend fun getCards(): List<Card> = apiCardService.getCards().toDomain()
}