package com.example.apptours.di

import com.example.apptours.App
import com.example.apptours.data.retrofit.OnlineToursApi
import com.example.apptours.view.home.SearchToursActivity
import com.example.apptours.view.listCountryFrom.ChooseFromFragment
import com.example.apptours.view.listHotels.ListOfHotelsActivity
import com.example.apptours.view.presenter.SearchPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(app: App)
    fun inject(searchToursActivity: SearchToursActivity)
    fun inject(listOfHotelsActivity: ListOfHotelsActivity)
    fun inject(chooseFragment: ChooseFromFragment)
    fun getOnlineToursApi(): OnlineToursApi
}