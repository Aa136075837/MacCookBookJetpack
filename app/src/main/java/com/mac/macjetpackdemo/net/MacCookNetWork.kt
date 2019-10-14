package com.mac.macjetpackdemo.net

import com.mac.macjetpackdemo.data.model.*
import com.mac.macjetpackdemo.net.cookapi.SearchApi
import retrofit2.Callback

class MacCookNetWork private constructor() {

    private val searchApi = ServiceCreator.create(SearchApi::class.java)

    fun searchCookByKeyword(keyword: String, callback: Callback<BaseModel<SearchResult>>) =
        searchApi.searchCook(keyword).enqueue(callback)

    fun getCookDetail(id: String, callback: Callback<BaseModel<DetailResult>>) =
        searchApi.getDetailById(id).enqueue(callback)

    fun getType(callback: Callback<BaseModel<TypeResult>>) = searchApi.getType().enqueue(callback)

    fun getTypeDetail(classId: String, start: String, num: String, callback: Callback<BaseModel<TypeDetail>>) =
        searchApi.getTypeDetail(classId, start, num).enqueue(callback)

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