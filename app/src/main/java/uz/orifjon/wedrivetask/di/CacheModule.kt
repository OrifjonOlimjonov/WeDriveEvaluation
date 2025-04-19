package uz.orifjon.wedrivetask.di

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import uz.orifjon.wedrivetask.cache.manager.CacheManager
import uz.orifjon.wedrivetask.cache.manager.CacheManagerImpl
import uz.orifjon.wedrivetask.cache.preferences.UserPreferences

val cacheModule = module {
    single<CacheManager> { CacheManagerImpl(androidContext(), "_cache_file") }
    single<UserPreferences> { UserPreferences(get()) }

}