package br.com.tamanduasoft.drinkwater.home.model

data class HomeState(
    val progress: Int,
    val objective: String,
    val accomplished: String,
    val pending: String
)