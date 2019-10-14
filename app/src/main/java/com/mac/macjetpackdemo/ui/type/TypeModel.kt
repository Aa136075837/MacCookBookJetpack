package com.mac.macjetpackdemo.ui.type

import androidx.lifecycle.ViewModel
import com.mac.macjetpackdemo.data.TypeRepository

class TypeModel(private val typeRepository: TypeRepository) : ViewModel() {
    fun getType() = typeRepository.getType()

    fun getTypeDetail(classId: String, start: String, num: String) = typeRepository.getTypeDetail(classId, start, num)
}