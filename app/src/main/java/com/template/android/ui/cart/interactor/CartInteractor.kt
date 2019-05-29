package com.template.android.ui.cart.interactor

import com.template.android.data.models.BurgerOrder
import com.template.android.ui.base.interactor.BaseInteractor
import io.reactivex.Single

interface CartInteractor : BaseInteractor {

    fun getAllBurgerOrders(): Single<List<BurgerOrder>>

}