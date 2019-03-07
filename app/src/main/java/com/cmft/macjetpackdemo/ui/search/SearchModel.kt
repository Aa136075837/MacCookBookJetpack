package com.cmft.macjetpackdemo.ui.search

import androidx.lifecycle.ViewModel
import com.cmft.macjetpackdemo.data.SearchRepository

class SearchModel(private val searchRepository: SearchRepository) : ViewModel() {

    fun getSearchDetail(keyword: String) = searchRepository.search(keyword)

}