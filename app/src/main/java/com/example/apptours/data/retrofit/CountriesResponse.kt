package com.example.apptours.data.retrofit

import com.google.gson.annotations.SerializedName

data class CountriesResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: String,
    @SerializedName("country_id") val countryId: Long? = null,
    @SerializedName("country_name") val countryName: String? = null,
    @SerializedName("visa_required") val visaRequired: Boolean? = null,
)
