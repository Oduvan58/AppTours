package com.example.apptours.data

import com.example.apptours.data.retrofit.CreateSearchBody
import com.example.apptours.data.retrofit.SearchBody
import com.example.apptours.domain.HotelsRepo
import com.example.apptours.domain.SearchKey
import com.example.apptours.domain.SearchResult
import com.example.apptours.domain.SearchToursUseCase
import javax.inject.Inject

class HotelsUseCaseImpl @Inject constructor(
    private val hotelsRepo: HotelsRepo,
    private val searchUseCase: SearchToursUseCase
) {

    suspend fun getHotels(): List<SearchResult> {
        return hotelsRepo.getHotels(getSearchKey().key)
    }

    private suspend fun getSearchKey(): SearchKey =
        hotelsRepo.createSearch(
            SearchBody(
                CreateSearchBody(
                    searchUseCase.searchGlobalStateFlow().value.from.cityId ?: 0,
                    listOf(searchUseCase.searchGlobalStateFlow().value.to.countryId ?: 0),
                    "2024-05-17",
                    "2024-05-30",
                    7,
                    17,
                    2
                )
            )
        )
}