package br.com.tamanduasoft.drinkwater.data

import br.com.tamanduasoft.drinkwater.domain.Cup
import br.com.tamanduasoft.drinkwater.domain.repository.CupRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class CupRepositoryImpl: CupRepository {

    override fun getAll(): Flow<List<Cup>> = flowOf(cups)

    companion object {
        private val cups = listOf(
            Cup(150),
            Cup(200),
            Cup(250),
            Cup(300),
            Cup(350),
            Cup(400),
            Cup(500),
            Cup(750),
            Cup(900),
            Cup(1000)
        )
    }
}