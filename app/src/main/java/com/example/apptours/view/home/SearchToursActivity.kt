package com.example.apptours.view.home

import android.content.Intent
import android.os.Bundle
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.apptours.R
import com.example.apptours.app
import com.example.apptours.databinding.ActivitySearchToursBinding
import com.example.apptours.view.listCountryFrom.ChooseFromFragment
import com.example.apptours.view.listHotels.ListOfHotelsActivity
import com.example.apptours.view.presenter.SearchPresenter
import com.example.apptours.view.presenter.SearchView
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class SearchToursActivity : MvpAppCompatActivity(), SearchView, ChooseFromFragment.OnDataPass {

    private lateinit var binding: ActivitySearchToursBinding

    @Inject
    lateinit var presenterProvider: Provider<SearchPresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        binding = ActivitySearchToursBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        app.appComponent.inject(this)
        openChooseFrom()
        openChooseTo()
        showChoice()
        findTours()
    }

    private fun showChoice() {
        TODO("Not yet implemented")
    }

    private fun openChooseTo() {
        TODO("Not yet implemented")
    }

    private fun openChooseFrom() {
        val chooseFromFragment = ChooseFromFragment()
        chooseFromFragment.show(supportFragmentManager, chooseFromFragment.tag)
    }

    private fun findTours() {
        startActivity(Intent(this, ListOfHotelsActivity::class.java))
    }

    override fun onDataPass(city: String, departCityId: Int) {
        var cityName = city
        binding.inputFromEditText.setText(cityName)
        presenter.setIdCity(departCityId)
    }

}