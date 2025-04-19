package uz.orifjon.wedrivetask.network.service.wallet

import io.ktor.client.HttpClient
import uz.orifjon.wedrivetask.data.models.wallet.WalletResponse
import uz.orifjon.wedrivetask.utils.extensions.getJson
import uz.orifjon.wedrivetask.utils.extensions.putJson

class ApiWalletServiceImpl(
    private val httpClient: HttpClient
) : ApiWalletService {

    override suspend fun getWallet(): WalletResponse =
        httpClient.getJson<WalletResponse>(GET_WALLET)

    override suspend fun putActiveMethod() = httpClient.putJson<Unit>(PUT_ACTIVE_METHOD){

    }
}

const val GET_WALLET = "wallet"
const val PUT_ACTIVE_METHOD = "wallet/method"