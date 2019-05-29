package com.template.android.ui.catalog.interactor

import com.template.android.data.models.Burger
import com.template.android.ui.base.interactor.BaseInteractor
import io.reactivex.Single

interface CatalogInteractor : BaseInteractor {
    fun getBurgers(): Single<List<Burger>>
}