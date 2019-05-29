package com.template.android.data.network

import com.template.android.data.models.Burger
import io.reactivex.Single
import retrofit2.http.GET


interface BurgerService {
    @GET("mobiletest1.json")
    fun getBurgers(): Single<List<Burger>>
}