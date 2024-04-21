package com.example.apptours.data.retrofit

import com.google.gson.annotations.SerializedName

data class BestValue(

    @SerializedName("total") var total: Int? = null,
    @SerializedName("subtotal") var subtotal: Int? = null,
    @SerializedName("original") var original: Int? = null

)