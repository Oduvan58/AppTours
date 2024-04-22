package com.example.apptours.view.listCountryTo

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.apptours.domain.Country

class ToAdapter(private val onClickToItem: (Country) -> Unit) :
    ListAdapter<Country, ToViewHolder>(ChooseToDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ToViewHolder(parent)

    override fun onBindViewHolder(holder: ToViewHolder, position: Int) {
        holder.bind(getItem(position), onClickToItem)
    }

}