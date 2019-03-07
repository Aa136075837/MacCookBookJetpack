package com.cmft.macjetpackdemo.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cmft.macjetpackdemo.data.DetailRepository

class DetailModelFactory(private val detailRepository: DetailRepository) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailModel(detailRepository) as T
    }
}