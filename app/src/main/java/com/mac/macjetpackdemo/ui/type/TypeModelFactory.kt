package com.mac.macjetpackdemo.ui.type

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mac.macjetpackdemo.data.TypeRepository

class TypeModelFactory(private val typeRepository: TypeRepository) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TypeModel(typeRepository) as T
    }
}