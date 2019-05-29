package com.template.android.ui.cart.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.template.android.R
import com.template.android.ui.cart.presenter.CartPresenter

class BurgerOrderAdapter(val burgers: List<CartPresenter.Companion.BurgerWithQuantity>) : RecyclerView.Adapter<BurgerOrderHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BurgerOrderHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_burger_pricing, parent, false)
    )

    override fun getItemCount() = burgers.size

    override fun onBindViewHolder(holder: BurgerOrderHolder, position: Int) {
        holder.bind(burgers[position])
    }

}