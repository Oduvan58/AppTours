package com.example.apptours.view.presenter

import com.example.apptours.domain.SearchToursUseCase
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class SearchPresenter @Inject constructor(
    private val searchUseCase: SearchToursUseCase
) : MvpPresenter<SearchView>() {

    private var idCity = 0
    private var idCountry = 0
    private var titleCountry = ""

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadSearchData()
    }

    fun setIdCity(cityId: Int) {
        idCity = cityId
    }

    fun setIdCountry(countryId: Int) {
        idCountry = countryId
    }

    fun setTitleCountry(title: String) {
        titleCountry = title
    }

    fun getTitleCountry() = titleCountry

    private fun loadSearchData() {
        presenterScope.launch {
            searchUseCase.searchGlobalStateFlow().collect {
                viewState.setSearch(it.from, it.to)
            }
        }
    }
}