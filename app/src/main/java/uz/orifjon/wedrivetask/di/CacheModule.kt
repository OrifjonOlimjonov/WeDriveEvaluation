package uz.orifjon.wedrivetask.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import uz.orifjon.wedrivetask.cache.CacheManager
import uz.orifjon.wedrivetask.cache.CacheManagerImp

val cacheModule = module {
    single<CacheManager> { CacheManagerImp(androidContext(), "_cache_file") }

}