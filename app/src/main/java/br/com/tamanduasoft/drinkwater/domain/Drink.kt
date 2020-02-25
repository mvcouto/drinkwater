package br.com.tamanduasoft.drinkwater.domain

import org.threeten.bp.LocalDateTime

data class Drink(
    val id: String? = null,
    val volume: Int,
    val dateTime: LocalDateTime
)