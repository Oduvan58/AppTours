package com.example.apptours.data.retrofit

import com.google.gson.annotations.SerializedName

data class DepartCitiesResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("country_id") val countryId: Long,
    @SerializedName("country_name") val countryName: String,
)
