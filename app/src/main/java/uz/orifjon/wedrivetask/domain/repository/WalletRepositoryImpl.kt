package uz.orifjon.wedrivetask.domain.repository

import uz.orifjon.wedrivetask.data.models.payment_method.PaymentMethodRequest
import uz.orifjon.wedrivetask.data.repository.WalletRepository
import uz.orifjon.wedrivetask.domain.mappers.PaymentType
import uz.orifjon.wedrivetask.domain.mappers.toDomain
import uz.orifjon.wedrivetask.domain.models.Wallet
import uz.orifjon.wedrivetask.network.service.wallet.ApiWalletService

class WalletRepositoryImpl(
    private val apiWalletService: ApiWalletService
) : WalletRepository {

    override suspend fun getWallet(): Wallet {

        val wallet = apiWalletService.getWallet()


        return wallet.toDomain()
    }

    override suspend fun changePaymentType(
        activeMethod: PaymentType,
        activeCardId: Long?
    ) {
        val paymentMethodRequest = PaymentMethodRequest(activeMethod.name, activeCardId)
        apiWalletService.putActiveMethod(paymentMethodRequest = paymentMethodRequest)
    }
}