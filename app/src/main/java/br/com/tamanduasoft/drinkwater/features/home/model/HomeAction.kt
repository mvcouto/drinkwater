package br.com.tamanduasoft.drinkwater.features.home.model

import br.com.tamanduasoft.drinkwater.domain.Cup

sealed class HomeAction {

    data class ShowDrinkingOptions(val cups: List<Cup>) : HomeAction()
}