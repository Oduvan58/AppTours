package com.example.apptours.view.listCountryTo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.apptours.R
import com.example.apptours.databinding.ActivityChooseToBinding
import com.example.apptours.databinding.ActivitySearchToursBinding

class ChooseToActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChooseToBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        binding = ActivityChooseToBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}