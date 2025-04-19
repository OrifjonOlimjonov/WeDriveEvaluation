package uz.orifjon.wedrivetask.network.service.promo

import io.ktor.client.HttpClient
import io.ktor.client.request.setBody
import uz.orifjon.wedrivetask.data.models.promo.PromoRequest
import uz.orifjon.wedrivetask.utils.extensions.postJson

class ApiPromoCodeServiceImpl(
    private val httpClient: HttpClient
) : ApiPromoCodeService {
    override suspend fun addPromo(promoRequest: PromoRequest) {
        httpClient.postJson<Unit>(POST_PROMO_CODE){
            setBody(promoRequest)
        }
    }
}


const val POST_PROMO_CODE = "promocode"