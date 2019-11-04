package com.mac.macjetpackdemo.net.cookapi

import com.mac.macjetpackdemo.data.model.*
import com.mac.macjetpackdemo.util.MacCookConstant
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
        @Query("num") num: String = "100",
        @Query("appkey") appkey: String = MacCookConstant.JDCLOUD_KEY
    ): Call<BaseModel<SearchResult>>

    @GET("detail")
    fun getDetailById(
        @Query("id") id: String,
        @Query("appkey") appkey: String = MacCookConstant.JDCLOUD_KEY
    ): Call<BaseModel<DetailResult>>

    @GET("recipe_class")
    fun getType(
        @Query("appkey") appkey: String = MacCookConstant.JDCLOUD_KEY
    ): Call<BaseModel<TypeResult>>

    @GET("byclass")
    fun getTypeDetail(
        @Query("classid") classid: String,
        @Query("start") start: String,
        @Query("num") num: String,
        @Query("appkey") appkey: String = MacCookConstant.JDCLOUD_KEY
    ): Call<BaseModel<TypeDetail>>
}