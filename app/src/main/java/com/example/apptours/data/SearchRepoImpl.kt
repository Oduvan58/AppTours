package com.example.apptours.data

import com.example.apptours.data.mapping.toCity
import com.example.apptours.data.mapping.toCountry
import com.example.apptours.data.mapping.toGetKey
import com.example.apptours.data.mapping.toSearchResult
import com.example.apptours.data.retrofit.DepartCitiesResponse
import com.example.apptours.data.retrofit.OnlineToursApi
import com.example.apptours.data.retrofit.SearchBody
import com.example.apptours.domain.City
import com.example.apptours.domain.Country
import com.example.apptours.domain.SearchKey
import com.example.apptours.domain.SearchRepo
import com.example.apptours.domain.SearchResult
import javax.inject.Inject

class SearchRepoImpl @Inject constructor (private val toursApi: OnlineToursApi): SearchRepo {

    override suspend fun getCities(): List<City> =
        toursApi.getDepartCities().toCity()

    override suspend fun getCountries(): List<Country> =
        toursApi.getCountries().toCountry()

    override suspend fun createSearch(searchBody: SearchBody): SearchKey {
        return toursApi.createSearch(searchBody).toGetKey()
    }

    override suspend fun getSearchResult(key: String): List<SearchResult> =
        toursApi.getSearchResults(key).results.toSearchResult()
}
