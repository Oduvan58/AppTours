package com.example.apptours.view.listHotels

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apptours.R
import com.example.apptours.databinding.ItemHotelBinding
import com.example.apptours.domain.Tour

class HotelViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_hotel, parent, false)
) {

    private val binding = ItemHotelBinding.bind(itemView)

    fun bind(tour: Tour) {
        with(binding) {
            titleHotelCardViewTextView.text = tour.title
            priceHotelCardViewTextView.text = tour.price?.total.toString()
        }
    }
}