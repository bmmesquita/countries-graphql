package dev.bmesquita.countriesgraphql.data

import com.apollographql.apollo3.ApolloClient
import dev.bmesquita.CountriesQuery
import dev.bmesquita.CountryQuery
import dev.bmesquita.countriesgraphql.domain.CountryClient
import dev.bmesquita.countriesgraphql.domain.model.DetailedCountry
import dev.bmesquita.countriesgraphql.domain.model.SimpleCountry

class ApolloCountryClient(
    private val apolloClient: ApolloClient
): CountryClient {

    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toSimpleCountry() }
            ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }
}