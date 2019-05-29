package com.template.android.ui.catalog.interactor

import com.template.android.data.models.Burger
import com.template.android.data.models.BurgerOrder
import com.template.android.ui.base.interactor.BaseInteractor
import io.reactivex.Single

interface CatalogInteractor : BaseInteractor {
    fun getBurgers(): Single<List<Burger>>

    fun getAllBurgerOrders(): Single<List<BurgerOrder>>

    fun getBurgerOrderWithRef(ref: Long): Single<List<BurgerOrder>>

    fun insertBurgerOrder(burgerOrder: BurgerOrder): Single<Long>

    fun deleteBurgerOrder(ref: Long): Single<Int>

    fun deleteAllBurgerOrder(): Single<Int>
}