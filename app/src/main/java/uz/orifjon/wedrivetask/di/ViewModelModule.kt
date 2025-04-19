package uz.orifjon.wedrivetask.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import uz.orifjon.wedrivetask.ui.screens.home.HomeScreenViewModel
import uz.orifjon.wedrivetask.ui.screens.home.adding_card.AddingCardViewModel


val viewModelModule = module {
    factoryOf(::HomeScreenViewModel)
    factoryOf(::AddingCardViewModel)
}
