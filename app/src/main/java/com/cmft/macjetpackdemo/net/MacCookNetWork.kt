package com.cmft.macjetpackdemo.net

import com.cmft.macjetpackdemo.data.model.BaseModel
import com.cmft.macjetpackdemo.data.model.DetailResult
import com.cmft.macjetpackdemo.data.model.SearchResult
import com.cmft.macjetpackdemo.net.api.SearchApi
import retrofit2.Callback

class MacCookNetWork private constructor() {

    private val searchApi = ServiceCreator.create(SearchApi::class.java)

    fun searchCookByKeyword(keyword: String, callback: Callback<BaseModel<SearchResult>>) =
        searchApi.searchCook(keyword).enqueue(callback)

    fun getCookDetail(id: String, callback: Callback<BaseModel<DetailResult>>) =
        searchApi.getDetailById(id).enqueue(callback)

    companion object {
        private var netWork: MacCookNetWork? = null

        fun getInstance(): MacCookNetWork {
            if (netWork == null) {
                synchronized(MacCookNetWork::class.java) {
                    if (netWork == null) {
                        netWork = MacCookNetWork()
                    }
                }
            }
            return netWork!!
        }
    }
}