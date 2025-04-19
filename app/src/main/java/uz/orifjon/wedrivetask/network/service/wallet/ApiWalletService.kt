package uz.orifjon.wedrivetask.network.service.wallet

import uz.orifjon.wedrivetask.data.models.payment_method.PaymentMethodRequest
import uz.orifjon.wedrivetask.data.models.wallet.WalletResponse

interface ApiWalletService {

    suspend fun getWallet(): WalletResponse

    suspend fun putActiveMethod(paymentMethodRequest: PaymentMethodRequest)
}