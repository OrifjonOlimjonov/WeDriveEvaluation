package uz.orifjon.wedrivetask

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import uz.orifjon.wedrivetask.di.networkModule
import uz.orifjon.wedrivetask.di.repositoryModule
import uz.orifjon.wedrivetask.di.viewModelModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()

            androidContext(this@App)

            modules(
                viewModelModule,
                networkModule,
                repositoryModule
            )
        }
    }

}