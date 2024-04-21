package com.example.apptours.data.retrofit

import com.google.gson.annotations.SerializedName

data class Results(

    @SerializedName("offer") var offer: Offer? = Offer(),
    @SerializedName("count") var count: Int? = null

)