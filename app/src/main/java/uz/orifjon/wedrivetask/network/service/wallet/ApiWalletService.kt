package uz.orifjon.wedrivetask.network.service.wallet

import uz.orifjon.wedrivetask.data.models.WalletResponse

interface ApiWalletService {

    suspend fun getWallet(): WalletResponse

}