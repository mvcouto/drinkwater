package br.com.tamanduasoft.drinkwater.domain

import br.com.tamanduasoft.drinkwater.domain.repository.DrinksRepository

class DrinkWaterInteractor(
    private val drinksRepository: DrinksRepository
) {

    suspend fun execute(drinkLog: Drink) {

    }
}