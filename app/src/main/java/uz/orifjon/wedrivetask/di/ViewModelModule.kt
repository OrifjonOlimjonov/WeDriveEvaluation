package uz.orifjon.wedrivetask.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import uz.orifjon.wedrivetask.ui.screens.home.HomeScreenViewModel


val viewModelModule = module {
    factoryOf(::HomeScreenViewModel)
}
