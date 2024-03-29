package com.mac.macjetpackdemo.ui.search

import androidx.lifecycle.ViewModel
import com.mac.macjetpackdemo.data.SearchRepository

class SearchModel(private val searchRepository: SearchRepository) : ViewModel() {

    fun getSearchDetail(keyword: String) = searchRepository.search(keyword)

    fun getListByClassId(classId: String, start: String, num: String) =
        searchRepository.getTypeDetail(classId, start, num)

}