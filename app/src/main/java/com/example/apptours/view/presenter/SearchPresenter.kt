package com.example.apptours.view.presenter

import android.util.Log
import com.example.apptours.data.retrofit.CreateSearchBody
import com.example.apptours.data.retrofit.SearchBody
import com.example.apptours.domain.SearchRepo
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject

class SearchPresenter @Inject constructor(
    private val searchRepo: SearchRepo
) : MvpPresenter<SearchView>() {

    private var idCity = 0

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun setIdCity(cityId: Int) {
        idCity = cityId
    }

    fun test() {
        presenterScope.launch {
            try {
                searchRepo.createSearch(
                    SearchBody(
                        CreateSearchBody(
                            idCity,
                            listOf(100),
                            "2024-06-15",
                            "2024-06-30",
                            7,
                            17,
                            2
                        )
                    )
                )
            } catch (e: Exception) {
                Log.e("MyTag", "Error", e)
            }
        }
    }
}