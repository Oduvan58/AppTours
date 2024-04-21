package com.example.apptours.data.retrofit

import com.google.gson.annotations.SerializedName

data class SearchBody(
    val search: CreateSearchBody
)

data class CreateSearchBody(
    @SerializedName("depart_city_id") val departCityId: Int,
    @SerializedName("region_ids") val regionIds: List<Int>,
    @SerializedName("start_from") val startFrom: String,
    @SerializedName("start_to") val startTo: String,
    @SerializedName("duration_from") val durationFrom: Int,
    @SerializedName("duration_to") val durationTo: Int,
    @SerializedName("adults") val adults: Int
)