package com.example.apptours.domain

import com.google.gson.annotations.SerializedName

data class Country(
    var id: Long,
    var name: String,
    val type: String,
    val countryId: Long? = null,
    val countryName: String? = null,
    val visaRequired: Boolean? = null,
)