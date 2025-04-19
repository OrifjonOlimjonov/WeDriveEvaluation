package uz.orifjon.wedrivetask.domain.repository

import uz.orifjon.wedrivetask.data.models.promo.PromoRequest
import uz.orifjon.wedrivetask.data.repository.PromoCodeRepository
import uz.orifjon.wedrivetask.network.service.promo.ApiPromoCodeService

class PromoCodeRepositoryImpl(
    private val apiPromoCodeService: ApiPromoCodeService
) : PromoCodeRepository {

    override suspend fun addPromoCode(code: String) {
        val promoRequest = PromoRequest(code = code)

        apiPromoCodeService.addPromo(promoRequest = promoRequest)
    }
}