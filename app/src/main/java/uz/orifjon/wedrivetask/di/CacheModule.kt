package uz.orifjon.wedrivetask.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import uz.orifjon.wedrivetask.cache.manager.CacheManager
import uz.orifjon.wedrivetask.cache.manager.CacheManagerImp
import uz.orifjon.wedrivetask.cache.preferences.UserPreferences

val cacheModule = module {
    single<CacheManager> { CacheManagerImp(androidContext(), "_cache_file") }
    single<UserPreferences> { UserPreferences(get()) }

}