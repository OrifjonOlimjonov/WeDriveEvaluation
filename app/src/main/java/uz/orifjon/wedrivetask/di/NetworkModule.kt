package uz.orifjon.wedrivetask.di

import io.ktor.client.HttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import uz.orifjon.wedrivetask.network.service.cards.ApiCardService
import uz.orifjon.wedrivetask.network.service.cards.ApiCardServiceImpl
import uz.orifjon.wedrivetask.network.service.promo.ApiPromoCodeService
import uz.orifjon.wedrivetask.network.service.promo.ApiPromoCodeServiceImpl
import uz.orifjon.wedrivetask.network.service.user.ApiUserService
import uz.orifjon.wedrivetask.network.service.user.ApiUserServiceImpl
import uz.orifjon.wedrivetask.network.service.wallet.ApiWalletService
import uz.orifjon.wedrivetask.network.service.wallet.ApiWalletServiceImpl
import uz.orifjon.wedrivetask.utils.extensions.httpClient

val networkModule = module {

    factory<HttpClient> { httpClient(androidContext(), get()) }

    factory<ApiWalletService> { ApiWalletServiceImpl(get()) }

    factory<ApiCardService> { ApiCardServiceImpl(get()) }

    factory<ApiPromoCodeService> { ApiPromoCodeServiceImpl(get()) }

    factory<ApiUserService> { ApiUserServiceImpl(get()) }

}