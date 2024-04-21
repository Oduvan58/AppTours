package com.example.apptours.view.listCountryTo

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apptours.domain.Country
import com.example.apptours.view.listCountryFrom.OnClickCityListener

class ToAdapter(private val clickOnCountry: OnClickCountryListener) : RecyclerView.Adapter<ToViewHolder>() {

    private var data = mutableListOf<Country>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(country: List<Country>) {
        data.clear()
        data.addAll(country)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ToViewHolder(parent)

    override fun onBindViewHolder(holder: ToViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener { clickOnCountry.onClickCountry(getItem(position)) }
    }

    override fun getItemCount() = data.size

    private fun getItem(pos: Int) = data[pos]
}