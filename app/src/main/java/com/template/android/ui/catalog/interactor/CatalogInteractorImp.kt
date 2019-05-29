package com.template.android.ui.catalog.interactor

import com.template.android.data.database.DBHelper
import com.template.android.data.models.Burger
import com.template.android.data.network.ApiHelper
import com.template.android.ui.base.interactor.BaseInteractor
import com.template.android.ui.base.interactor.BaseInteractorImp
import io.reactivex.Single
import javax.inject.Inject

class CatalogInteractorImp @Inject constructor(dbHelper: DBHelper, val apiHelper: ApiHelper) :
    CatalogInteractor, BaseInteractorImp() {

    override fun getBurgers(): Single<List<Burger>> = apiHelper.getBurgers()
}