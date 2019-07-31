package com.mac.macjetpackdemo.ui.detail

import androidx.lifecycle.ViewModel
import com.mac.macjetpackdemo.data.DetailRepository

class DetailModel(private val detailRepository: DetailRepository) : ViewModel() {
    fun getDetailById(id: String) = detailRepository.getDetailByClassid(id)
}