package uz.orifjon.wedrivetask.data.repository

import uz.orifjon.wedrivetask.domain.models.Wallet

interface WalletRepository {

    suspend fun getWallet(): Wallet

}