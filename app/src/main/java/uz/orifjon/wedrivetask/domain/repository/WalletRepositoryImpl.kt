package uz.orifjon.wedrivetask.domain.repository

import uz.orifjon.wedrivetask.data.repository.WalletRepository
import uz.orifjon.wedrivetask.network.service.wallet.ApiWalletService

class WalletRepositoryImpl(
    private val apiWalletService: ApiWalletService
) : WalletRepository {

    override suspend fun getWallet() {

        val wallet = apiWalletService.getWallet()



    }
}