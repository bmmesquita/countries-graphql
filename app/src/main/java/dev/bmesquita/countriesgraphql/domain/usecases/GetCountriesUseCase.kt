package dev.bmesquita.countriesgraphql.domain.usecases

import dev.bmesquita.countriesgraphql.domain.CountryClient
import dev.bmesquita.countriesgraphql.domain.model.SimpleCountry

class GetCountriesUseCase(
    private val countryClient: CountryClient
) {

    suspend fun execute(): List<SimpleCountry> {
        return countryClient
            .getCountries()
            .sortedBy { it.name }
    }
}