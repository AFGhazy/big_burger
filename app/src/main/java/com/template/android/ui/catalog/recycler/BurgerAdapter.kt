package com.template.android.ui.catalog.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.template.android.R
import com.template.android.data.models.Burger

class BurgerAdapter(val burgers: List<Burger>) : RecyclerView.Adapter<BurgerHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BurgerHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_burger, parent, false)
    )

    override fun getItemCount() = burgers.size

    override fun onBindViewHolder(holder: BurgerHolder, position: Int) {
        holder.bind(burgers[position])
    }

}