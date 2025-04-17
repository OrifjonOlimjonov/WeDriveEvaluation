package uz.orifjon.wedrivetask.di

import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import uz.orifjon.wedrivetask.data.repository.WalletRepository
import uz.orifjon.wedrivetask.domain.repository.WalletRepositoryImpl

val repositoryModule = module {

    singleOf(::WalletRepositoryImpl) { bind<WalletRepository>() }

}