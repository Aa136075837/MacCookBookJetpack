package com.mac.macjetpackdemo.net

import com.mac.macjetpackdemo.data.model.BaseModel
import com.mac.macjetpackdemo.data.model.DetailResult
import com.mac.macjetpackdemo.data.model.SearchResult
import com.mac.macjetpackdemo.net.cookapi.SearchApi
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