package com.template.android.ui.cart.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.template.android.R
import com.template.android.data.models.Burger
import com.template.android.ui.base.view.BaseFragment
import com.template.android.ui.cart.CartContract
import com.template.android.ui.cart.interactor.CartInteractor
import com.template.android.ui.cart.presenter.CartPresenter
import com.template.android.ui.cart.recycler.BurgerOrderAdapter
import com.template.android.ui.catalog.view.CatalogActivity
import com.template.android.util.formatKurusPriceIntoLira
import kotlinx.android.synthetic.main.fragment_cart.*
import javax.inject.Inject


class CartFragment  : BaseFragment(), CartContract.View {
    @Inject
    internal lateinit var presenter: CartPresenter<CartContract.View, CartInteractor>
    var burgers: List<Burger>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_cart, container, false)

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        setUp()
    }

    override fun setUp() {
        setUpDI()
        presenter.attachView(this)
        burgers = arguments?.getParcelableArrayList(CartActivity.BURGER_LIST)
        burgers?.let { presenter.loadedSuccessfully(it) }
    }

    override fun showBurgersWithQuantities(burgerWithQuantities: List<CartPresenter.Companion.BurgerWithQuantity>) {
        burgersRv.layoutManager = LinearLayoutManager(activity)
        burgersRv.adapter = BurgerOrderAdapter(burgerWithQuantities)
    }

    override fun showTotalPrice(price: Long) {
        priceTv.text = getString(R.string.cart_total_pricing, formatKurusPriceIntoLira(price.toDouble()))
    }

    override fun onDestroy() {
        presenter.dropView()
        super.onDestroy()
    }

    private fun setUpDI() {
        activityComponent?.inject(this)
    }

    companion object {
        fun newInstance() = CartFragment()
    }
}