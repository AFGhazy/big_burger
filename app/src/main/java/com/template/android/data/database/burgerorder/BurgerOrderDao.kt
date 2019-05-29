package com.template.android.data.database.burgerorder

import androidx.room.*
import com.template.android.data.models.BurgerOrder
import com.template.android.data.models.BurgerOrder.Companion.ORDER_TABLE_NAME
import io.reactivex.Single


@Dao
interface BurgerOrderDao {
    @Query("SELECT * FROM `order`")
    fun getAllBurgerOrders(): Single<List<BurgerOrder>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBurgerOrder(burgerOrder: BurgerOrder): Single<Long>

    @Query("DELETE FROM `order` WHERE id = :ref")
    fun deleteBurgerOrder(ref: Long): Single<Int>

    @Query("DELETE FROM `order`")
    fun deleteAllBurgerOrders(): Single<Int>

    @Query("SELECT * FROM `order` WHERE id = :ref")
    fun getBurgerOrderWithRef(ref: Long): Single<List<BurgerOrder>>
}