package com.cmft.macjetpackdemo.net.cookapi

import com.cmft.macjetpackdemo.data.model.BaseModel
import com.cmft.macjetpackdemo.data.model.DetailResult
import com.cmft.macjetpackdemo.data.model.SearchResult
import com.cmft.macjetpackdemo.util.MacCookConstant
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {
    /**
     * search?keyword=白菜&num=10&appkey=您申请的APPKEY
     */
    @GET("search")
    fun searchCook(
        @Query("keyword") keyword: String,
        @Query("num") num: String = "30",
        @Query("appkey") appkey: String = MacCookConstant.JDCLOUD_KEY
    ): Call<BaseModel<SearchResult>>

    @GET("detail")
    fun getDetailById(
        @Query("id") id: String,
        @Query("appkey") appkey: String = MacCookConstant.JDCLOUD_KEY
    ): Call<BaseModel<DetailResult>>
}