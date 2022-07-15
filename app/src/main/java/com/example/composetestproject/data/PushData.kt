package com.example.composetest.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
class PushData {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "productId")
    var id: Int = 0

    @ColumnInfo(name = "productName")
    var productName: String = ""
    var quantity: Int = 0

    constructor()

    constructor(productname: String, quantity: Int) {
        this.id = id
        this.productName = productname
        this.quantity = quantity
    }
}