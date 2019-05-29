package com.template.android.ui.catalog.interactor

import com.template.android.data.database.DBHelper
import com.template.android.data.models.Burger
import com.template.android.data.models.BurgerOrder
import com.template.android.data.network.ApiHelper
import com.template.android.ui.base.interactor.BaseInteractorImp
import io.reactivex.Single
import javax.inject.Inject

class CatalogInteractorImp @Inject constructor(val dbHelper: DBHelper, val apiHelper: ApiHelper) :
    CatalogInteractor, BaseInteractorImp() {
    override fun deleteAllBurgerOrder() = dbHelper.deleteAllBurgerOrders()

    override fun getBurgerOrderWithRef(ref: Long): Single<List<BurgerOrder>> =
        dbHelper.getBurgerOrderWithRef(ref)

    override fun getAllBurgerOrders() = dbHelper.getAllBurgerOrders()

    override fun insertBurgerOrder(burgerOrder: BurgerOrder) =
        dbHelper.insertBurgerOrder(burgerOrder)



    override fun getBurgers(): Single<List<Burger>> = apiHelper.getBurgers()

    override fun deleteBurgerOrder(ref: Long) = dbHelper.deleteBurgerOrder(ref)
}