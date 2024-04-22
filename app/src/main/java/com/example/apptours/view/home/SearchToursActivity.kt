package com.example.apptours.view.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.apptours.R
import com.example.apptours.app
import com.example.apptours.databinding.ActivitySearchToursBinding
import com.example.apptours.domain.SearchCity
import com.example.apptours.domain.SearchCountry
import com.example.apptours.view.listCountryFrom.ChooseFromFragment
import com.example.apptours.view.listCountryTo.ChooseToFragment
import com.example.apptours.view.listHotels.ListOfHotelsActivity
import com.example.apptours.view.presenter.SearchPresenter
import com.example.apptours.view.presenter.SearchView
import moxy.MvpAppCompatActivity
import javax.inject.Inject
import javax.inject.Provider


class SearchToursActivity : MvpAppCompatActivity(), SearchView, ChooseFromFragment.OnDataPass,
    ChooseToFragment.OnToDataPass {

    private lateinit var binding: ActivitySearchToursBinding

    @Inject
    lateinit var presenterProvider: Provider<SearchPresenter>
    private val presenter by lazy { presenterProvider.get() }

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
        findTours()
    }

    private fun openChooseTo() {
        binding.inputToEditText.setOnClickListener {
            val chooseToFragment = ChooseToFragment()
            chooseToFragment.show(supportFragmentManager, chooseToFragment.tag)
        }
    }

    private fun openChooseFrom() {
        binding.inputFromEditText.setOnClickListener {
            val chooseFromFragment = ChooseFromFragment()
            chooseFromFragment.show(supportFragmentManager, chooseFromFragment.tag)
        }
    }

    private fun findTours() {
        binding.searchButton.setOnClickListener {
            val titleCountry = presenter.getTitleCountry()
            val intent = Intent(this, ListOfHotelsActivity::class.java)
            intent.putExtra("TitleCountry", titleCountry)
            startActivity(intent)
        }
    }

    override fun onDataPass(city: String, departCityId: Int) {
        binding.inputFromEditText.setText(city)
        presenter.setIdCity(departCityId)
    }

    override fun onToDataPass(country: String, countryId: Int) {
        binding.inputToEditText.setText(country)
        presenter.setIdCountry(countryId)
        presenter.setTitleCountry(country)
    }

    override fun setSearch(searchFrom: SearchCity, searchTo: SearchCountry) {
        Log.d("@@@", "setSearch() called")
    }

}