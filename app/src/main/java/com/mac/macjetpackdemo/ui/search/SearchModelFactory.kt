package com.mac.macjetpackdemo.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mac.macjetpackdemo.data.SearchRepository

class SearchModelFactory(private val repository: SearchRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SearchModel(repository) as T
    }
}