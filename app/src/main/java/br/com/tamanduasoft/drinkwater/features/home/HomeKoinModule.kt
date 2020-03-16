package br.com.tamanduasoft.drinkwater.features.home

import br.com.tamanduasoft.drinkwater.data.CupRepositoryImpl
import br.com.tamanduasoft.drinkwater.domain.repository.CupRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeKoinModule = module {
    factory { CupRepositoryImpl() as CupRepository }
    viewModel { HomeViewModel(get()) }
}