package dev.bmesquita.countriesgraphql.data

import dev.bmesquita.CountriesQuery
import dev.bmesquita.CountryQuery
import dev.bmesquita.countriesgraphql.domain.model.DetailedCountry
import dev.bmesquita.countriesgraphql.domain.model.SimpleCountry

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry {
    return DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
        currency = currency ?: "No currency",
        languages = languages.map { it.name },
        continent = continent.name
    )
}

fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry {
    return SimpleCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
    )
}