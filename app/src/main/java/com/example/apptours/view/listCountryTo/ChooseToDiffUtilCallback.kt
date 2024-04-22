package com.example.apptours.view.listCountryTo

import androidx.recyclerview.widget.DiffUtil
import com.example.apptours.domain.Country

class ChooseToDiffUtilCallback : DiffUtil.ItemCallback<Country>() {

    override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean =
        oldItem == newItem

}