package dev.bmesquita.countriesgraphql.domain

import dev.bmesquita.countriesgraphql.domain.model.DetailedCountry
import dev.bmesquita.countriesgraphql.domain.model.SimpleCountry

interface CountryClient {
    suspend fun getCountries(): List<SimpleCountry>
    suspend fun getCountry(code: String): DetailedCountry?
}