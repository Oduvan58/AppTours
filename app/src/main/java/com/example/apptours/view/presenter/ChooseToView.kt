package com.example.apptours.view.presenter

import com.example.apptours.domain.City
import com.example.apptours.domain.Country
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface ChooseToView : MvpView {

    fun getCountries(list: List<Country>)
    fun onDismiss(country: String, countryId: Int)
}