package com.example.composetest.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.composetest.data.PushData
import com.example.composetest.database.ProductRoomDatabase
import com.example.composetest.repository.ProductRepository

class MainViewModel(application: Application) : ViewModel() {

    val allProducts: LiveData<List<PushData>>
    private val repository: ProductRepository
    val searchResults: MutableLiveData<List<PushData>>

    init {
        val productDb = ProductRoomDatabase.getInstance(application)
        val productDao = productDb.productDao()
        repository = ProductRepository(productDao)

        allProducts = repository.allProducts
        searchResults = repository.searchResults
    }

    fun insertProduct(product: PushData) {
        repository.insertProduct(product)
    }

    fun findProduct(name: String) {
        repository.findProduct(name)
    }

    fun deleteProduct(name: String) {
        repository.deleteProduct(name)
    }
}