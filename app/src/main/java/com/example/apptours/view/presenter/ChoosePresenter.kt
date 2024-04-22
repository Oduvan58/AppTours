package com.example.apptours.view.presenter

import android.util.Log
import com.example.apptours.domain.City
import com.example.apptours.domain.SearchCity
import com.example.apptours.domain.SearchRepo
import com.example.apptours.domain.SearchToursUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class ChoosePresenter @Inject constructor(
    private val searchRepo: SearchRepo,
    private val searchUseCase: SearchToursUseCase
) : MvpPresenter<ChooseView>() {

    private var mCity = ""
    private var cities: List<City> = emptyList()
    private var filteredCities: List<City> = emptyList()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadCities()
    }

    fun onChangeListener(city: String) {
        mCity = city
        filteredCities = cities.filter { it.name.contains(city, ignoreCase = true) }
        viewState.getCities(filteredCities)
    }

    private fun loadCities() {
        presenterScope.launch(Dispatchers.Main) {
            try {
                cities = searchRepo.getCities().take(100)
                viewState.getCities(cities)
            } catch (e: Exception) {
                Log.e("@@@", "Exception", e)
            }
        }
    }

    fun onClickItem(item: City) {
        mCity = item.name
        viewState.onDismiss(mCity, item.id.toInt())
        searchUseCase.setCities(SearchCity(item.name, item.id.toInt()))
    }
}