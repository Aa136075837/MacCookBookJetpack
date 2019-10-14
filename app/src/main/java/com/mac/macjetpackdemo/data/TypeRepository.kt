package com.mac.macjetpackdemo.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mac.macjetpackdemo.data.db.TypeDao
import com.mac.macjetpackdemo.data.model.BaseModel
import com.mac.macjetpackdemo.data.model.TypeDetail
import com.mac.macjetpackdemo.data.model.TypeResult
import com.mac.macjetpackdemo.net.MacCookNetWork
import com.mac.macjetpackdemo.net.Status
import com.mac.macjetpackdemo.util.MacCookExecutors
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TypeRepository private constructor(val typeDao: TypeDao, val netWork: MacCookNetWork) {

    companion object {
        private var instance: TypeRepository? = null

        fun getInstance(typeDao: TypeDao, netWork: MacCookNetWork): TypeRepository {
            if (instance == null) {
                synchronized(TypeRepository::class.java) {
                    if (instance == null) {
                        instance = TypeRepository(typeDao, netWork)
                    }
                }
            }
            return instance!!
        }
    }

    fun getType(): MutableLiveData<Status<TypeResult>> {
        val liveData = MutableLiveData<Status<TypeResult>>()
        liveData.value = Status.loading(null)
        MacCookExecutors.netWork.execute {
            netWork.getType(object : Callback<BaseModel<TypeResult>> {
                override fun onFailure(p0: Call<BaseModel<TypeResult>>, p1: Throwable) {
                    liveData.postValue(Status.error("获取失败", null))
                    Log.e("getType", p1.message)
                }

                override fun onResponse(p0: Call<BaseModel<TypeResult>>, p1: Response<BaseModel<TypeResult>>) {
                    liveData.postValue(Status.success(p1.body()?.result))
                    Log.e("getType", p1.message())
                }
            })
        }
        return liveData
    }

    fun getTypeDetail(classId: String, start: String, num: String) {
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
    }
}