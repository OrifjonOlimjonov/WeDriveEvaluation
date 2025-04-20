package uz.orifjon.wedrivetask.data.repository

import uz.orifjon.wedrivetask.domain.mappers.PaymentType
import uz.orifjon.wedrivetask.domain.models.Wallet

interface WalletRepository {

    suspend fun getWallet(): Wallet

    suspend fun changePaymentType(
        activeMethod: PaymentType,
        activeCardId: Long?
    )

}