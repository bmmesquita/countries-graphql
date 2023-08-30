package dev.bmesquita.countriesgraphql.domain.model

data class SimpleCountry(
    val code: String,
    val name: String,
    val emoji: String,
    val capital: String
)