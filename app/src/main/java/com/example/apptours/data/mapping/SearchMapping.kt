package com.example.apptours.data.mapping

import com.example.apptours.data.retrofit.CountriesResponse
import com.example.apptours.data.retrofit.CreateSearchResponse
import com.example.apptours.data.retrofit.DepartCitiesResponse
import com.example.apptours.data.retrofit.SearchResultResponse
import com.example.apptours.domain.City
import com.example.apptours.domain.Country
import com.example.apptours.domain.SearchKey
import com.example.apptours.domain.SearchResult
import com.example.apptours.domain.Tour

fun CreateSearchResponse.toGetKey(): SearchKey = SearchKey(key)

fun List<DepartCitiesResponse>.toCity(): List<City> =
    this.map {
        City(
            id = it.id,
            name = it.name
        )
    }

fun List<CountriesResponse>.toCountry(): List<Country> =
    this.map {
        Country(
            id = it.id,
            name = it.name,
            type = it.type,
            countryName = it.countryName ?: "",
            countryId = it.countryId ?: 0
        )
    }

fun List<SearchResultResponse>.toSearchResult(): List<SearchResult> =
    this.map {
        SearchResult(
            it.offer.hotelId,
            it.offer.price,
            it.offer.departCityId,
            it.offer.regionId,
            it.offer.adults,
            it.offer.startDate,
            it.offer.duration,
            it.offer.originalName
        )
    }

fun List<SearchResultResponse>.toTour(): List<SearchResult> =
    this.map {
        SearchResult(
            it.offer.hotelId,
            it.offer.price,
            it.offer.departCityId,
            it.offer.regionId,
            it.offer.adults,
            it.offer.startDate,
            it.offer.duration,
            it.offer.originalName
        )
    }