package com.example.apptours.data.retrofit

import com.google.gson.annotations.SerializedName

data class OriginalPrice(

    @SerializedName("price") var price: Int? = null,
    @SerializedName("currency") var currency: String? = null

)