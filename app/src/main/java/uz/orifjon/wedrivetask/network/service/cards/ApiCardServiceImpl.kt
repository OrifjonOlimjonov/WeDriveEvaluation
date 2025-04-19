package uz.orifjon.wedrivetask.network.service.cards

import io.ktor.client.HttpClient
import io.ktor.client.request.setBody
import uz.orifjon.wedrivetask.data.models.card.CardRequest
import uz.orifjon.wedrivetask.data.models.card.CardResponse
import uz.orifjon.wedrivetask.utils.extensions.getJson
import uz.orifjon.wedrivetask.utils.extensions.postJson

class ApiCardServiceImpl(
    private val httpClient: HttpClient
) : ApiCardService {

    override suspend fun getCards(): List<CardResponse> = httpClient.getJson(GET_CARDS)

    override suspend fun addCard(cardRequest: CardRequest) =
        httpClient.postJson<CardResponse>(POST_CARDS) {
            setBody(cardRequest)
        }


}

const val GET_CARDS = "cards"
const val POST_CARDS = "cards"