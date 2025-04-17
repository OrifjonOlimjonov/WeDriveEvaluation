package uz.orifjon.wedrivetask.network.service.wallet

import io.ktor.client.HttpClient
import uz.orifjon.wedrivetask.data.models.WalletResponse
import uz.orifjon.wedrivetask.utils.extensions.getJson

class ApiWalletServiceImpl(
   private val httpClient: HttpClient
): ApiWalletService {

    override suspend fun getWallet(): WalletResponse =
       httpClient.getJson<WalletResponse>(GET_WALLET)
}

const val GET_WALLET = "wallet"