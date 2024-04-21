package com.example.apptours.data.retrofit

import com.google.gson.annotations.SerializedName

data class GetSearchResultResponse(

    @SerializedName("results") var results: ArrayList<Results> = arrayListOf(),
    @SerializedName("stats") var stats: Stats? = Stats()

)
