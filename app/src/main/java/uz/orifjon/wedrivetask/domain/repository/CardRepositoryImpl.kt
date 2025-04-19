package uz.orifjon.wedrivetask.domain.repository

import uz.orifjon.wedrivetask.data.repository.CardRepository
import uz.orifjon.wedrivetask.domain.mappers.toDomain
import uz.orifjon.wedrivetask.domain.mappers.toRequest
import uz.orifjon.wedrivetask.domain.models.Card
import uz.orifjon.wedrivetask.network.service.cards.ApiCardService

class CardRepositoryImpl(
    private val apiCardService: ApiCardService
) : CardRepository {


    override suspend fun addCard(card: Card): Card {
        val newCard = apiCardService.addCard(card.toRequest())

        return newCard.toDomain()
    }
}