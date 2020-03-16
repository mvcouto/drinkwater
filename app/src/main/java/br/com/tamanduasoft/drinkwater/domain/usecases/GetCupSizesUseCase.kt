package br.com.tamanduasoft.drinkwater.domain.usecases

import br.com.tamanduasoft.drinkwater.domain.Cup
import br.com.tamanduasoft.drinkwater.domain.repository.CupRepository
import kotlinx.coroutines.flow.Flow

class GetCupSizesUseCase(private val cupRepository: CupRepository) {

    fun execute(): Flow<List<Cup>> = cupRepository.getAll()
}