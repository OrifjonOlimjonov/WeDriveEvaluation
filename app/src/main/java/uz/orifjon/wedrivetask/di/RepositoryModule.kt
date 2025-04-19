package uz.orifjon.wedrivetask.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import uz.orifjon.wedrivetask.data.repository.CardRepository
import uz.orifjon.wedrivetask.data.repository.PromoCodeRepository
import uz.orifjon.wedrivetask.data.repository.UserRepository
import uz.orifjon.wedrivetask.data.repository.WalletRepository
import uz.orifjon.wedrivetask.domain.repository.CardRepositoryImpl
import uz.orifjon.wedrivetask.domain.repository.PromoCodeRepositoryImpl
import uz.orifjon.wedrivetask.domain.repository.UserRepositoryImpl
import uz.orifjon.wedrivetask.domain.repository.WalletRepositoryImpl

val repositoryModule = module {

    singleOf(::WalletRepositoryImpl) { bind<WalletRepository>() }
    singleOf(::PromoCodeRepositoryImpl) { bind<PromoCodeRepository>() }
    singleOf(::UserRepositoryImpl) { bind<UserRepository>() }
    singleOf(::CardRepositoryImpl) { bind<CardRepository>() }

}