package com.example.apptours.domain

interface HotelRepo {

    fun getHotels(
        onSuccess: (List<Tour>) -> Unit,
        onError: ((Throwable) -> Unit)? = null,
    )
}