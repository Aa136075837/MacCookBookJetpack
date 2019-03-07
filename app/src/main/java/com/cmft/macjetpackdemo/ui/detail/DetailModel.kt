package com.cmft.macjetpackdemo.ui.detail

import androidx.lifecycle.ViewModel
import com.cmft.macjetpackdemo.data.DetailRepository

class DetailModel(private val detailRepository: DetailRepository) : ViewModel() {
    fun getDetailById(id: String) = detailRepository.getDetailByClassid(id)
}