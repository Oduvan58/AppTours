package com.example.apptours.view.presenter

import android.util.Log
import com.example.apptours.data.HotelsUseCaseImpl
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class HotelsPresenter @Inject constructor(
    private val hotelUseCaseImpl: HotelsUseCaseImpl
) : MvpPresenter<HotelsView>() {

    override fun onFirstViewAttach() {
        Log.d("@@@", "onFirstViewAttach() called")
        super.onFirstViewAttach()
        loadHotels()
    }

    private fun loadHotels() {
        presenterScope.launch {
            try {
                val listTours = hotelUseCaseImpl.getHotels()
                Log.d("@@@", listTours.size.toString())
                viewState.loadHotels(listTours)
            } catch (e: Exception) {
                Log.e("@@@", "Exception", e)
            }
        }
    }

}