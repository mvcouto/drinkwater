package br.com.tamanduasoft.drinkwater.domain.repository

import br.com.tamanduasoft.drinkwater.domain.Cup
import kotlinx.coroutines.flow.Flow

interface CupRepository {

    fun getAll(): Flow<List<Cup>>
}