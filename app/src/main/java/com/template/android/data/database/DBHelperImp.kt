package com.template.android.data.database

import com.template.android.data.models.BurgerOrder
import io.reactivex.Single
import javax.inject.Inject

class DBHelperImp @Inject constructor(val roomDatabase: RoomDatabase) : DBHelper {
    override fun getBurgerOrderWithRef(ref: Long): Single<List<BurgerOrder>> =
        roomDatabase.burgerOrderDao().getBurgerOrderWithRef(ref)

    override fun deleteAllBurgerOrders() = roomDatabase.burgerOrderDao().deleteAllBurgerOrders()

    override fun getAllBurgerOrders() =
        roomDatabase.burgerOrderDao().getAllBurgerOrders()

    override fun insertBurgerOrder(burgerOrder: BurgerOrder) = roomDatabase.burgerOrderDao().insertBurgerOrder(burgerOrder)

    override fun deleteBurgerOrder(ref: Long) = roomDatabase.burgerOrderDao().deleteBurgerOrder(ref)

}