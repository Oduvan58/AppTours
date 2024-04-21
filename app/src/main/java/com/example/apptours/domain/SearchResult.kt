package com.example.apptours.domain

import com.example.apptours.data.retrofit.Price

data class SearchResult(
    val hotelId: Int,
    val price: Price,
    val departCityId: Int,
    val regionId: Int,
    val adults: Int,
    val startDate: String,
    val duration: Int,
    val originalName: String,
)
