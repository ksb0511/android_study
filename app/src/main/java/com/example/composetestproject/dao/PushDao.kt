package com.example.composetest.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.composetest.data.PushData

@Dao
interface PushDao {

    @Insert
    fun insertProduct(product: PushData)

    @Query("SELECT * FROM products WHERE productName = :name")
    fun findProduct(name: String): List<PushData>

    @Query("DELETE FROM products WHERE productName = :name")
    fun deleteProduct(name: String)

    @Query("SELECT * FROM products")
    fun getAllProducts(): LiveData<List<PushData>>
}