package com.example.apptours.view.presenter

import android.util.Log
import com.example.apptours.domain.City
import com.example.apptours.domain.Country
import com.example.apptours.domain.SearchCountry
import com.example.apptours.domain.SearchRepo
import com.example.apptours.domain.SearchToursUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class ChooseToPresenter @Inject constructor(
    private val searchRepo: SearchRepo,
    private val searchUseCase: SearchToursUseCase
) : MvpPresenter<ChooseToView>() {

    private var mCountry = ""
    private var countries: List<Country> = emptyList()
    private var filteredCountries: List<Country> = emptyList()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadCountries()
    }

    fun onChangeListener(country: String) {
        mCountry = country
        filteredCountries = countries.filter { it.name.contains(country, ignoreCase = true) }
        viewState.getCountries(filteredCountries)
    }

    private fun loadCountries() {
        presenterScope.launch(Dispatchers.Main) {
            try {
                countries = searchRepo.getCountries().take(100)
                viewState.getCountries(countries)
            } catch (e: Exception) {
                Log.e("@@@", "Exception", e)
            }
        }
    }

    fun onClickToItem(item: Country) {
        mCountry = item.name
        viewState.onDismiss(mCountry, item.id.toInt())
        searchUseCase.setCountries(SearchCountry(item.name, item.id.toInt()))
    }
}