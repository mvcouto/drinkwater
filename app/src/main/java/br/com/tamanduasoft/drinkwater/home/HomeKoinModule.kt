package br.com.tamanduasoft.drinkwater.home

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeKoinModule = module {
    viewModel { HomeViewModel() }
}