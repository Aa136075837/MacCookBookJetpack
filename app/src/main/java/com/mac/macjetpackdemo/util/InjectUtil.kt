package com.mac.macjetpackdemo.util

import com.mac.macjetpackdemo.data.DetailRepository
import com.mac.macjetpackdemo.data.SearchRepository
import com.mac.macjetpackdemo.data.TypeRepository
import com.mac.macjetpackdemo.data.db.DetailDao
import com.mac.macjetpackdemo.data.db.TypeDao
import com.mac.macjetpackdemo.net.MacCookNetWork
import com.mac.macjetpackdemo.ui.detail.DetailModelFactory
import com.mac.macjetpackdemo.ui.search.SearchModelFactory
import com.mac.macjetpackdemo.ui.type.TypeModelFactory

object InjectUtil {
    private fun getSearchRepository() = SearchRepository.getInstance(DetailDao(), MacCookNetWork.getInstance())

    private fun getDetailRepository() = DetailRepository.getInstance(DetailDao(), MacCookNetWork.getInstance())

    private fun getTypeRepository() = TypeRepository.getInstance(TypeDao(), MacCookNetWork.getInstance())

    fun getSearchModelFactory() = SearchModelFactory(getSearchRepository())

    fun getDetailModelFactory() = DetailModelFactory(getDetailRepository())

    fun getTypeModelFactor() = TypeModelFactory(getTypeRepository())
}