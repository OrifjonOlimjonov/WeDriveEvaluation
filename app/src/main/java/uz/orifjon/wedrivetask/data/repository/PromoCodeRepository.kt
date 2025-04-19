package uz.orifjon.wedrivetask.data.repository

interface PromoCodeRepository {

    suspend fun addPromoCode(code: String)

}