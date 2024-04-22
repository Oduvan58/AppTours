package com.example.apptours.view.listHotels

import android.os.Bundle
import android.util.Log
import com.example.apptours.app
import com.example.apptours.databinding.ActivityListOfHotelsBinding
import com.example.apptours.domain.SearchResult
import com.example.apptours.view.presenter.HotelsPresenter
import com.example.apptours.view.presenter.HotelsView
import moxy.MvpAppCompatActivity
import javax.inject.Inject
import javax.inject.Provider

class ListOfHotelsActivity : MvpAppCompatActivity(), HotelsView {

    private lateinit var binding: ActivityListOfHotelsBinding

    @Inject
    lateinit var presenterProvider: Provider<HotelsPresenter>
    private val presenter by lazy { presenterProvider.get() }

    private lateinit var hotelsAdapter: HotelsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListOfHotelsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("@@@", "onCreate() called")
        app.appComponent.inject(this)
        val titleCountry = intent.getStringExtra("TitleCountry")
        binding.toolbarInfo.titleCountryTextView.text = titleCountry
        initRecyclerView()
        backClick()
    }

    private fun initRecyclerView() {
        hotelsAdapter = HotelsAdapter()
        binding.listHotelsRecyclerView.adapter = hotelsAdapter
    }

    private fun backClick() {
        binding.toolbarInfo.backImageView.setOnClickListener {
            finish()
        }
    }

    override fun loadHotels(tour: List<SearchResult>) {
        Log.d("@@@", "loadHotels() called")
        hotelsAdapter.submitList(tour)
    }

}