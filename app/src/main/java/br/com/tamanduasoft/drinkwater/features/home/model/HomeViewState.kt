package br.com.tamanduasoft.drinkwater.features.home.model

data class HomeViewState(
    val progress: Int,
    val objective: String,
    val accomplished: String,
    val pending: String
)