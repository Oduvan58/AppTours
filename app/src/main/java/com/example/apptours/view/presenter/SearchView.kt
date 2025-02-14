package com.example.apptours.view.presenter

import com.example.apptours.domain.SearchCity
import com.example.apptours.domain.SearchCountry
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface SearchView : MvpView {

    fun setSearch(searchFrom: SearchCity, searchTo: SearchCountry)
}