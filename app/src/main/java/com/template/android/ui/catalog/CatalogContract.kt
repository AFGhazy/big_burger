package com.template.android.ui.catalog

import com.template.android.data.models.Burger
import com.template.android.ui.base.presenter.BasePresenter
import com.template.android.ui.base.view.BaseViewContract
import com.template.android.ui.catalog.interactor.CatalogInteractor

interface CatalogContract {
    interface Presenter<V : View, I : CatalogInteractor> : BasePresenter<V, I> {
        fun loadedSuccessfully()
    }

    interface View : BaseViewContract {
        fun showBurgers(burgers: List<Burger>)
    }
}