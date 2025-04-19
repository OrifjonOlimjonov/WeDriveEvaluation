package uz.orifjon.wedrivetask.network.service.wallet

import io.ktor.client.HttpClient
import io.ktor.client.request.setBody
import uz.orifjon.wedrivetask.data.models.payment_method.PaymentMethodRequest
import uz.orifjon.wedrivetask.data.models.wallet.WalletResponse
import uz.orifjon.wedrivetask.utils.extensions.getJson
import uz.orifjon.wedrivetask.utils.extensions.putJson

class ApiWalletServiceImpl(
    private val httpClient: HttpClient
) : ApiWalletService {

    override suspend fun getWallet(): WalletResponse =
        httpClient.getJson<WalletResponse>(GET_WALLET)

    override suspend fun putActiveMethod(paymentType: PaymentMethodRequest) {
        httpClient.putJson<Unit>(PUT_ACTIVE_METHOD) {
            setBody(paymentType)
        }
    }
}

const val GET_WALLET = "wallet"
const val PUT_ACTIVE_METHOD = "wallet/method"