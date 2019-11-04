package com.mac.macjetpackdemo.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mac.macjetpackdemo.data.db.DetailDao
import com.mac.macjetpackdemo.data.model.BaseModel
import com.mac.macjetpackdemo.data.model.SearchResult
import com.mac.macjetpackdemo.data.model.TypeDetail
import com.mac.macjetpackdemo.net.MacCookNetWork
import com.mac.macjetpackdemo.net.Status
import com.mac.macjetpackdemo.util.MacCookExecutors
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

    fun getTypeDetail(classId: String, start: String, num: String): MutableLiveData<Status<TypeDetail>> {
        val liveData = MutableLiveData<Status<TypeDetail>>()
        liveData.value = Status.loading(null)
        MacCookExecutors.netWork.execute {
            netWork.getTypeDetail(classId, start, num, object : Callback<BaseModel<TypeDetail>> {
                override fun onFailure(p0: Call<BaseModel<TypeDetail>>, p1: Throwable) {
                    liveData.postValue(Status.error("获取失败", null))
                }

                override fun onResponse(p0: Call<BaseModel<TypeDetail>>, p1: Response<BaseModel<TypeDetail>>) {
                    liveData.postValue(Status.success(p1.body()?.result))
                }
            })
        }
        return liveData
    }
}