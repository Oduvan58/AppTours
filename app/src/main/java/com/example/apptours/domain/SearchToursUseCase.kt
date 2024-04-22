package com.example.apptours.domain

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class SearchToursUseCase @Inject constructor() {

    private val search = MutableStateFlow(SearchGlobal())

    fun setCities(searchCity: SearchCity) {
        search.tryEmit(search.value.copy(from = searchCity))
    }

    fun setCountries(searchCountry: SearchCountry) {
        search.tryEmit(search.value.copy(to = searchCountry))
    }

    fun searchGlobalStateFlow(): StateFlow<SearchGlobal> =
        search.asStateFlow()

}