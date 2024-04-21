package com.example.apptours.view.presenter

import android.util.Log
import com.example.apptours.domain.City
import com.example.apptours.domain.SearchRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class ChoosePresenter @Inject constructor(
    private val searchRepo: SearchRepo,
) : MvpPresenter<ChooseView>() {

    private var mCity = ""

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadCities()
    }

    fun onChangeListener(city: String) {
        mCity = city
    }

    private fun loadCities() {
        presenterScope.launch(Dispatchers.Main) {
            try {
                val cities = searchRepo.getCities().take(20)
                viewState.getCities(cities)
            } catch (e: Exception) {
                Log.e("tag", "Exception", e)
            }
        }
    }

    fun onClickItem(item: City) {
        mCity = item.name
        viewState.onDismiss(mCity, item.id.toInt())
    }
}