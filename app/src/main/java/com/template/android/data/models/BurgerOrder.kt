package com.template.android.data.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.template.android.data.models.BurgerOrder.Companion.ORDER_TABLE_NAME
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = ORDER_TABLE_NAME)
data class BurgerOrder(
    @PrimaryKey(autoGenerate = false)
    val id: Long,
    @ColumnInfo(name = QUANTITY_FIELD)
    val quantity: Int
) : Parcelable {

    companion object {
        const val ORDER_TABLE_NAME = "order"
        const val QUANTITY_FIELD = "quantity"
    }
}