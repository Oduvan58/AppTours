package com.example.apptours

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import com.example.apptours.di.AppComponent
import com.example.apptours.di.DaggerAppComponent

class App : Application() {

    val appComponent: AppComponent by lazy { DaggerAppComponent.create() }

}

val Context.app: App get() = applicationContext as App

val Fragment.app: App
    get() = requireActivity().application as App