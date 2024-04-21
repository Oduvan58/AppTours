package com.example.apptours.domain

import com.google.gson.annotations.SerializedName

data class DepartCities(
    val id: Long,
    val name: String,
    val countryId: Long,
    val countryName: String,
    val type: String,
)
