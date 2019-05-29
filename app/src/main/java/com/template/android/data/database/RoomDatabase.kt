package com.template.android.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.template.android.data.database.burgerorder.BurgerOrderDao
import com.template.android.data.models.BurgerOrder


@Database(entities = [(BurgerOrder::class)], version = 1)
abstract class RoomDatabase : RoomDatabase() {
    abstract fun burgerOrderDao(): BurgerOrderDao
}