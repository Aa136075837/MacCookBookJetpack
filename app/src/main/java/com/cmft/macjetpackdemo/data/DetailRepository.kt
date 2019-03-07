package com.cmft.macjetpackdemo.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cmft.macjetpackdemo.data.db.DetailDao
import com.cmft.macjetpackdemo.data.model.BaseModel
import com.cmft.macjetpackdemo.data.model.DetailResult
import com.cmft.macjetpackdemo.data.model.SearchResult
import com.cmft.macjetpackdemo.net.MacCookNetWork
import com.cmft.macjetpackdemo.net.Status
import com.cmft.macjetpackdemo.util.MacCookExecutors
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailRepository private constructor(val detailDao: DetailDao, val netWork: MacCookNetWork) {

    companion object {
        private var mDetailRepository: DetailRepository? = null
        fun getInstance(detailDao: DetailDao, netWork: MacCookNetWork): DetailRepository {
            if (mDetailRepository == null) {
                synchronized(DetailRepository::class.java) {
                    if (mDetailRepository == null) {
                        mDetailRepository = DetailRepository(detailDao, netWork)
                    }
                }
            }
            return mDetailRepository!!
        }
    }

    fun getDetailByClassid(id: String): LiveData<Status<DetailResult>> {
        val liveData = MutableLiveData<Status<DetailResult>>()
        liveData.postValue(Status.loading(null))
        MacCookExecutors.diskIo.execute {
            netWork.getCookDetail(id, object : Callback<BaseModel<DetailResult>> {
                override fun onFailure(call: Call<BaseModel<DetailResult>>, t: Throwable) {
                    liveData.postValue(Status.error(t.message.toString(), null))
                }

                override fun onResponse(call: Call<BaseModel<DetailResult>>, response: Response<BaseModel<DetailResult>>) {
                    liveData.postValue(Status.success(response.body()?.result))
                }
            })
        }
        return liveData
    }
}