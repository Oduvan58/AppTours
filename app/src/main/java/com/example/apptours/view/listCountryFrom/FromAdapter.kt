package com.example.apptours.view.listCountryFrom

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.apptours.domain.City

class FromAdapter(private val onClickItem: (City) -> Unit) :
    ListAdapter<City, FromViewHolder>(ChooseDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FromViewHolder(parent)

    override fun onBindViewHolder(holder: FromViewHolder, position: Int) {
        holder.bind(getItem(position), onClickItem)
    }

}