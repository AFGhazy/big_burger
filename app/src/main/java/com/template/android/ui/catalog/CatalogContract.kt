package com.template.android.ui.catalog

import com.template.android.data.models.Burger
import com.template.android.ui.base.presenter.BasePresenter
import com.template.android.ui.base.view.BaseViewContract
import com.template.android.ui.catalog.interactor.CatalogInteractor

interface CatalogContract {
    interface Presenter<V : View, I : CatalogInteractor> : BasePresenter<V, I>, BurgerOrderOperations {
        fun loadedSuccessfully()
        fun showMyCartClicked()
        fun resetAllClicked()
    }

    interface View : BaseViewContract {
        fun showBurgers(burgers: List<Burger>)
        fun navigateToCart(burgers: List<Burger>)
    }

    interface BurgerOrderOperations {
        fun incrementOrder(ref: Long)
        fun resetItem(ref: Long)
    }
}