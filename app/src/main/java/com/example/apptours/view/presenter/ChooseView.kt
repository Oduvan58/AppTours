package com.example.apptours.view.presenter

import com.example.apptours.domain.City
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface ChooseView : MvpView {

    fun getCities(list: List<City>)
    fun onDismiss(city: String, departCityId: Int)
}