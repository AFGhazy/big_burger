package com.template.android.ui.cart.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.template.android.ui.cart.presenter.CartPresenter
import com.template.android.util.formatKurusPriceIntoLira
import kotlinx.android.synthetic.main.item_burger_pricing.view.*

class BurgerOrderHolder(val v: View) : RecyclerView.ViewHolder(v) {
    fun bind(burger: CartPresenter.Companion.BurgerWithQuantity) {
        v.titleTv.text = burger.burger.title
        v.priceTv.text = formatKurusPriceIntoLira(burger.quantity * burger.burger.price.toDouble())
        v.quantityTv.text = burger.quantity.toString()

    }
}