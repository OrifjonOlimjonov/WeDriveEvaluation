package uz.orifjon.wedrivetask.domain.mappers

import uz.orifjon.wedrivetask.data.models.card.CardRequest
import uz.orifjon.wedrivetask.data.models.card.CardResponse
import uz.orifjon.wedrivetask.domain.models.Card


fun Card.toRequest() = CardRequest(
    number = cardNumber,
    expire_date = expiredDate
)


fun List<CardResponse>.toDomain() = map { it.toDomain() }

fun CardResponse.toDomain() = Card(
    cardNumber = number,
    expiredDate = expire_date
)
