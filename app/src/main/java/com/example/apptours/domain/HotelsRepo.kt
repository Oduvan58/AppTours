package com.example.apptours.domain

import com.example.apptours.data.retrofit.SearchBody

interface HotelsRepo {
    suspend fun createSearch(searchBody: SearchBody): SearchKey
    suspend fun getHotels(key: String): List<SearchResult>
}