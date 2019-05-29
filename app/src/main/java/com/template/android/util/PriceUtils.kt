package com.template.android.util

import com.template.android.util.Constants.Companion.NUMBER_OF_KURUS_IN_LIRA

fun kurusToLira(value: Double): Double = value / NUMBER_OF_KURUS_IN_LIRA

fun formatKurusPriceIntoLira(value: Double): String = "%.2f".format(kurusToLira(value)).toString() + " ₺"