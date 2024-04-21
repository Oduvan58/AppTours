package com.example.apptours.data.retrofit

import com.google.gson.annotations.SerializedName


data class ResultResponse(
    val results: List<SearchResultResponse>
)


data class SearchResultResponse(
    val offer: SearchResponse,
    val count: Int
)


data class SearchResponse(
    @SerializedName("hotel_id") val hotelId: Int,
    val price: Price,
    @SerializedName("depart_city_id") val departCityId: Int,
    @SerializedName("region_id") val regionId: Int,
    val adults: Int,
    @SerializedName("start_date") val startDate: String,
    val duration: Int,
    @SerializedName("original_name") val originalName: String,
)
