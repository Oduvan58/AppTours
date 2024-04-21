package com.example.apptours.domain

import com.example.apptours.data.retrofit.Price
import com.google.gson.annotations.SerializedName

data class Tour(
    @SerializedName("id") var id: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("hotel_id") var hotelId: Int? = null,
    @SerializedName("price") var price: Price? = Price(),
)
