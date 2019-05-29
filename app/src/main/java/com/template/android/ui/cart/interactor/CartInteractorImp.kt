package com.template.android.ui.cart.interactor

import com.template.android.data.database.DBHelper
import com.template.android.data.models.BurgerOrder
import com.template.android.data.network.ApiHelper
import com.template.android.ui.base.interactor.BaseInteractorImp
import io.reactivex.Single
import javax.inject.Inject

class CartInteractorImp  @Inject constructor(val dbHelper: DBHelper, val apiHelper: ApiHelper) :
    CartInteractor, BaseInteractorImp() {
    override fun getAllBurgerOrders() = dbHelper.getAllBurgerOrders()
}