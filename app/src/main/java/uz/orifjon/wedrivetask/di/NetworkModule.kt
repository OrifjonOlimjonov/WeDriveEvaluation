package uz.orifjon.wedrivetask.di

import io.ktor.client.HttpClient
import org.koin.dsl.module
import uz.orifjon.wedrivetask.network.service.wallet.ApiWalletService
import uz.orifjon.wedrivetask.network.service.wallet.ApiWalletServiceImpl
import uz.orifjon.wedrivetask.utils.extensions.httpClient

val networkModule = module {

    factory<HttpClient> { httpClient() }

    factory<ApiWalletService> { ApiWalletServiceImpl(get()) }

}