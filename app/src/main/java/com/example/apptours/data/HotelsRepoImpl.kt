package com.example.apptours.data

import com.example.apptours.data.mapping.toGetKey
import com.example.apptours.data.mapping.toTour
import com.example.apptours.data.retrofit.OnlineToursApi
import com.example.apptours.data.retrofit.SearchBody
import com.example.apptours.domain.HotelsRepo
import com.example.apptours.domain.SearchKey
import com.example.apptours.domain.SearchResult
import com.example.apptours.domain.Tour
import javax.inject.Inject

class HotelsRepoImpl @Inject constructor(
    private val onlineToursApi: OnlineToursApi
) : HotelsRepo {

    override suspend fun createSearch(searchBody: SearchBody): SearchKey {
        return onlineToursApi.createSearch(searchBody).toGetKey()
    }

    override suspend fun getHotels(key: String): List<SearchResult> =
        onlineToursApi.getSearchResults(key).results.toTour()

}