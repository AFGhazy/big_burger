package com.template.android.data.network

import com.template.android.data.models.Burger
import io.reactivex.Single


interface ApiHelper {
    fun getBurgers(): Single<List<Burger>>
}