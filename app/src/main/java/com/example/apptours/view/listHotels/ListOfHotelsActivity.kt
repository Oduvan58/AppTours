package com.example.apptours.view.listHotels

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apptours.databinding.ActivityListOfHotelsBinding

class ListOfHotelsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListOfHotelsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        binding = ActivityListOfHotelsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        binding.toolbarInfo.backImageView.setOnClickListener {
            finish()
        }
    }

    private fun initRecyclerView() {
        binding.listHotelsRecyclerView.layoutManager = LinearLayoutManager(this)
    }

}