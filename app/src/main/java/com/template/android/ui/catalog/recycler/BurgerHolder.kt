package com.template.android.ui.catalog.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.template.android.data.models.Burger
import com.template.android.ui.catalog.CatalogContract
import com.template.android.util.formatKurusPriceIntoLira
import kotlinx.android.synthetic.main.item_burger.view.*

class BurgerHolder(val v: View, val burgerOrderOperations: CatalogContract.BurgerOrderOperations) : RecyclerView.ViewHolder(v) {
    fun bind(burger: Burger) {
        Glide.with(v).load(burger.thumbnail).into(v.burgerIv)
        v.titleTv.text = burger.title
        v.descriptionTv.text = burger.description
        v.priceTv.text = formatKurusPriceIntoLira(burger.price.toDouble())
        v.addMorebtn.setOnClickListener {
            burgerOrderOperations.incrementOrder(burger.reference)
        }

        v.removeAllBtn.setOnClickListener {
            burgerOrderOperations.resetItem(burger.reference)
        }
    }
}