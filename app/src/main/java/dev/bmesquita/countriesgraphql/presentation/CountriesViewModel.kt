package dev.bmesquita.countriesgraphql.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.bmesquita.countriesgraphql.domain.model.DetailedCountry
import dev.bmesquita.countriesgraphql.domain.model.SimpleCountry
import dev.bmesquita.countriesgraphql.domain.usecases.GetCountriesUseCase
import dev.bmesquita.countriesgraphql.domain.usecases.GetCountryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase,
    private val getCountryUseCase: GetCountryUseCase
): ViewModel() {

    var state by  mutableStateOf(CountriesState())
        private set

    init {
        viewModelScope.launch {
            state = state.copy(isLoading = true)

            state = state.copy(
                countries = getCountriesUseCase.execute(),
                isLoading = false
            )
        }
    }

    fun selectCountry(code: String) {
        viewModelScope.launch {
            state = state.copy(selectedCountry = getCountryUseCase.execute(code))
        }
    }

    fun dismissCountryDialog() {
        state = state.copy(selectedCountry = null)
    }

    data class CountriesState(
        val countries: List<SimpleCountry> = emptyList(),
        val isLoading: Boolean = false,
        val selectedCountry: DetailedCountry? = null
    )
}