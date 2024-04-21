package com.example.apptours.domain

import com.example.apptours.data.retrofit.SearchBody

interface SearchToursUseCase {

    suspend fun getCities(): List<City>
    suspend fun getCountries(): List<Country>
    suspend fun createSearch(searchBody: SearchBody): SearchKey
    suspend fun getSearchResult(key: String): List<SearchResult>

}