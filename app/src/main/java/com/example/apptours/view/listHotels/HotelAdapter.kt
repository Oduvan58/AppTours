package com.example.apptours.view.listHotels

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apptours.domain.Tour

class HotelAdapter : RecyclerView.Adapter<HotelViewHolder>() {

    private var data = mutableListOf<Tour>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(tour: List<Tour>) {
        data.clear()
        data.addAll(tour)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HotelViewHolder(parent)

    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount() = data.size

    private fun getItem(pos: Int) = data[pos]
}