package com.example.apptours.view.listCountryTo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apptours.R
import com.example.apptours.databinding.ItemChooseToBinding
import com.example.apptours.domain.Country

class ToViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_choose_to, parent, false)
) {

    private val binding = ItemChooseToBinding.bind(itemView)

    fun bind(country: Country, onClickItem: (Country) -> Unit) {
        with(binding) {
            titleCityCardViewTextView.text = country.name
            cityCardView.setOnClickListener { onClickItem(country) }
        }
    }
}