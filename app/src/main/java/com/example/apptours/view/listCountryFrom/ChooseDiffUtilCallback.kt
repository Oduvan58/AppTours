package com.example.apptours.view.listCountryFrom

import androidx.recyclerview.widget.DiffUtil
import com.example.apptours.domain.City

class ChooseDiffUtilCallback : DiffUtil.ItemCallback<City>() {

    override fun areItemsTheSame(oldItem: City, newItem: City): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: City, newItem: City): Boolean =
        oldItem == newItem

}