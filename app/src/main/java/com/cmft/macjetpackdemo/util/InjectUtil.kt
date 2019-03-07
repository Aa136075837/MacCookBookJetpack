package com.cmft.macjetpackdemo.util

import com.cmft.macjetpackdemo.data.DetailRepository
import com.cmft.macjetpackdemo.data.SearchRepository
import com.cmft.macjetpackdemo.data.db.DetailDao
import com.cmft.macjetpackdemo.net.MacCookNetWork
import com.cmft.macjetpackdemo.ui.detail.DetailModelFactory
import com.cmft.macjetpackdemo.ui.search.SearchModelFactory

object InjectUtil {
    private fun getSearchRepository() = SearchRepository.getInstance(DetailDao(), MacCookNetWork.getInstance())

    private fun getDetailRepository() = DetailRepository.getInstance(DetailDao(), MacCookNetWork.getInstance())

    fun getSearchModelFactory() = SearchModelFactory(getSearchRepository())

    fun getDetailModelFactory() = DetailModelFactory(getDetailRepository())
}