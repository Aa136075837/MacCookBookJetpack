package com.cmft.macjetpackdemo.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cmft.macjetpackdemo.data.db.DetailDao
import com.cmft.macjetpackdemo.data.model.BaseModel
import com.cmft.macjetpackdemo.data.model.SearchResult
import com.cmft.macjetpackdemo.net.MacCookNetWork
import com.cmft.macjetpackdemo.net.Status
import com.cmft.macjetpackdemo.util.MacCookExecutors
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchRepository private constructor(val detailDao: DetailDao, val netWork: MacCookNetWork) {

    companion object {
        private var instance: SearchRepository? = null

        fun getInstance(detailDao: DetailDao, netWork: MacCookNetWork): SearchRepository {
            if (instance == null) {
                synchronized(SearchRepository::class.java) {
                    if (instance == null) {
                        instance = SearchRepository(detailDao, netWork)
                    }
                }
            }
            return instance!!
        }
    }

    fun search(keyword: String): LiveData<Status<SearchResult>> {
        val liveData = MutableLiveData<Status<SearchResult>>()
        liveData.value = Status.loading(null)
        MacCookExecutors.diskIo.execute {
            netWork.searchCookByKeyword(keyword, object : Callback<BaseModel<SearchResult>> {
                override fun onFailure(call: Call<BaseModel<SearchResult>>, t: Throwable) {
                    liveData.postValue(Status.error("搜索失败", null))
                }

                override fun onResponse(
                    call: Call<BaseModel<SearchResult>>, response: Response<BaseModel<SearchResult>>
                ) {
                    val result = response.body()?.result
                    liveData.postValue(Status.success(result))
                }
            })

        }
        return liveData
    }
}