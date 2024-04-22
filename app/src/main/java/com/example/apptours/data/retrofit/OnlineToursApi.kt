package com.example.apptours.data.retrofit

import com.example.apptours.domain.Country
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface OnlineToursApi {

    @POST("/api/v2/public/searches")
    suspend fun createSearch(@Body searchBody: SearchBody): CreateSearchResponse

    @GET("/api/v2/public/searches/{key}/results")
    suspend fun getSearchResults(
        @Path("key") key: String
    ): ResultResponse

    @GET("/api/v2/public/depart_cities")
    suspend fun getDepartCities(): List<DepartCitiesResponse>

    @GET("/api/v2/public/regions")
    suspend fun getCountries(): List<CountriesResponse>

}