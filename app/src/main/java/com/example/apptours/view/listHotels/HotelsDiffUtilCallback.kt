package com.example.apptours.view.listHotels

import androidx.recyclerview.widget.DiffUtil
import com.example.apptours.domain.SearchResult

class HotelsDiffUtilCallback : DiffUtil.ItemCallback<SearchResult>() {

    override fun areItemsTheSame(oldItem: SearchResult, newItem: SearchResult): Boolean =
        oldItem.hotelId == newItem.hotelId

    override fun areContentsTheSame(oldItem: SearchResult, newItem: SearchResult): Boolean =
        oldItem == newItem
}