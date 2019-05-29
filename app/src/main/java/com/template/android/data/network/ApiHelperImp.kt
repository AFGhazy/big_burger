package com.template.android.data.network

import com.template.android.data.models.Burger
import io.reactivex.Single
import javax.inject.Inject

class ApiHelperImp  @Inject constructor(val burgerService: BurgerService) : ApiHelper {
    override fun getBurgers(): Single<List<Burger>> {
        return burgerService.getBurgers()
    }
}