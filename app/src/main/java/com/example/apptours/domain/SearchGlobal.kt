package com.example.apptours.domain

data class SearchGlobal(
    val from: SearchCity = SearchCity(),
    val to: SearchCountry = SearchCountry()
)
