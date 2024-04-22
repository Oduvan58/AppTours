package com.example.apptours.view.listHotels

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.apptours.domain.SearchResult

class HotelsAdapter : ListAdapter<SearchResult, HotelsViewHolder>(HotelsDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HotelsViewHolder(parent)

    override fun onBindViewHolder(holder: HotelsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}