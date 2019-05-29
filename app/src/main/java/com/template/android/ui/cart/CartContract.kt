package com.template.android.ui.cart

import com.template.android.data.models.Burger
import com.template.android.ui.base.presenter.BasePresenter
import com.template.android.ui.base.view.BaseViewContract
import com.template.android.ui.cart.interactor.CartInteractor
import com.template.android.ui.cart.presenter.CartPresenter

interface CartContract {
    interface Presenter<V : View, I : CartInteractor> : BasePresenter<V, I>{
        fun loadedSuccessfully(burgers: List<Burger>)

    }

    interface View : BaseViewContract {
        fun showBurgersWithQuantities(burgerWithQuantities: List<CartPresenter.Companion.BurgerWithQuantity>)
        fun showTotalPrice(price: Long)
    }
}