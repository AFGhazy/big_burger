package com.template.android.data.models

import com.google.gson.annotations.SerializedName

data class Burger(
    @SerializedName("ref")
    val reference: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("price")
    val price: Double)