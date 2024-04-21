package com.example.apptours.data.retrofit

import com.google.gson.annotations.SerializedName

data class Services(

    @SerializedName("insurance") var insurance: String? = null,
    @SerializedName("transfer") var transfer: String? = null

)