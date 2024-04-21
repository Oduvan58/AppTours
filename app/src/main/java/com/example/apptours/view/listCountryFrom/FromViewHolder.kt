package com.example.apptours.view.listCountryFrom

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apptours.R
import com.example.apptours.databinding.ItemChooseFromBinding
import com.example.apptours.domain.City

class FromViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_choose_from, parent, false)
) {

    private val binding = ItemChooseFromBinding.bind(itemView)

    fun bind(city: City, onClickItem: (City) -> Unit) {
        with(binding) {
            titleCityCardViewTextView.text = city.name
            cityCardView.setOnClickListener { onClickItem(city) }
        }
    }
}