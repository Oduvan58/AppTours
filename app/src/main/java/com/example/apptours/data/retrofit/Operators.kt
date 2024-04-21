package com.example.apptours.data.retrofit

import com.google.gson.annotations.SerializedName

data class Operators(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("count") var count: Int? = null,
    @SerializedName("best_value") var bestValue: BestValue? = BestValue()

)