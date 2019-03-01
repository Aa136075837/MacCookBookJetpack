package com.cmft.macjetpackdemo.util

import com.cmft.macjetpackdemo.data.SearchRepository
import com.cmft.macjetpackdemo.data.db.DetailDao
import com.cmft.macjetpackdemo.net.MacCookNetWork
import com.cmft.macjetpackdemo.ui.detail.DetailModelFactory

object InjectUtil {
    private fun getDetailRepository() = SearchRepository.getInstance(DetailDao(), MacCookNetWork.getInstance())

    fun getDetailModelFactory() = DetailModelFactory(getDetailRepository())
}