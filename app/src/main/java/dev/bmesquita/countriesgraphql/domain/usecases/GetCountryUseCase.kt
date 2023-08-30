package dev.bmesquita.countriesgraphql.domain.usecases

import dev.bmesquita.countriesgraphql.domain.CountryClient
import dev.bmesquita.countriesgraphql.domain.model.DetailedCountry

class GetCountryUseCase(
    private val countryClient: CountryClient
) {

    suspend fun execute(code: String): DetailedCountry? {
        return countryClient.getCountry(code)
    }
}