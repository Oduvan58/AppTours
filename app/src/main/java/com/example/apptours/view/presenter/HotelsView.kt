package com.example.apptours.view.presenter

import com.example.apptours.domain.SearchResult
import com.example.apptours.domain.Tour
import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy::class)
interface HotelsView : MvpView {
    fun loadHotels(tour: List<SearchResult>)
}