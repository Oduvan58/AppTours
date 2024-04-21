package com.example.apptours.data.retrofit

import com.google.gson.annotations.SerializedName

data class CountriesResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
)
