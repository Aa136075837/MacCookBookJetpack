package com.cmft.macjetpackdemo.ui.detail

import androidx.lifecycle.ViewModel
import com.cmft.macjetpackdemo.data.SearchRepository

class DetailModel(private val searchRepository: SearchRepository) : ViewModel() {

    fun getSearchDetail(keyword: String) = searchRepository.search(keyword)

}