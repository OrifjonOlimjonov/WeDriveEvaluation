package uz.orifjon.wedrivetask.network.service.promo

import uz.orifjon.wedrivetask.data.models.promo.PromoRequest

interface ApiPromoService {

    suspend fun addPromo(promoRequest: PromoRequest)

}